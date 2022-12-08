package com.demo.dashboard.service;

import com.demo.dashboard.repository.DashboardRepository;
import com.demo.dashboard.repository.model.*;
import com.demo.dashboard.utility.exception.DBException;
import com.demo.dashboard.utility.property.Constantes;
import com.demo.dashboard.utility.property.PropertiesExternos;
import com.demo.dashboard.utility.request.*;
import com.demo.dashboard.utility.types.ResponseStatusType;
import com.demo.dashboard.utility.response.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class DashboardService implements Serializable {

    private static final long serialVersionUID = 1L;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private PropertiesExternos propertiesExternos;

    @Autowired
    private DashboardRepository dashboardRepository;


    public StandardGetChartsDataResponse getChartsData(String msjTx, HeaderRequest headerRequest,
                                                    GetChartsDataByFilterRequest request) throws Exception {

        logger.info(msjTx + Constantes.METODOINICIO + "getChartsData");
        logger.info(Constantes.SEPARADOR);
        StandardGetChartsDataResponse response = new StandardGetChartsDataResponse();
        GetChartsDataResponse getChartsDataResponse = new GetChartsDataResponse();
        ChartDataResponse totalChartData = new ChartDataResponse();
        ChartDataResponse quantityChartData = new ChartDataResponse();
        ChartDataResponse priceChartData = new ChartDataResponse();
        List<RowTableDataResponse> tableDataResponseList = new ArrayList<>();
        RowTableDataResponse rowTableDataResponse = new RowTableDataResponse();
        List<RowTableData> tableDataList = new ArrayList<>();
        List<SerieDataResponse> totalSeries = new ArrayList<>();
        List<SerieDataResponse> quantitySeries = new ArrayList<>();
        List<SerieDataResponse> priceSeries = new ArrayList<>();
        ResponseStatusType responseStatus = new ResponseStatusType();
        HashMap<String, Integer> categoriesMap = new HashMap<String, Integer>();
        HashSet<String> categoriesSet = new HashSet<String>();
        HashMap<String, Integer> groupedByMap = new HashMap<String, Integer>();
        HashSet<String> groupedBySet = new HashSet<String>();
        List<String> categoriesList = new ArrayList<>();

        SerieDataResponse totalSerie = new SerieDataResponse();
        SerieDataResponse quantitySerie = new SerieDataResponse();
        SerieDataResponse priceSerie = new SerieDataResponse();

        try {

            logger.info(msjTx + Constantes.ACTIVIDAD1);
            List<RowChartDataGrouped> rowChartDataGroupedList = new ArrayList<>();
            rowChartDataGroupedList = dashboardRepository.getChartsDataGrouped(msjTx, request);
            tableDataList = dashboardRepository.getTableData(msjTx, request);

            if(rowChartDataGroupedList != null && rowChartDataGroupedList.size() >0 &&
               tableDataList != null && tableDataList.size() >0){
                logger.info(msjTx + "totalRows>0: " + rowChartDataGroupedList.size() + " in grouped by " + request.getGroupBy());

                //getting lists with unique elements, grouped by date and another selected group
                rowChartDataGroupedList.stream().forEach(rowChartDataGrouped -> {
                    logger.info(rowChartDataGrouped.getPurchaseDate() + "/" + rowChartDataGrouped.getNameGroupedBy() + "/"
                            + rowChartDataGrouped.getSumQuantity() + "/" + rowChartDataGrouped.getAvgPrice() + "/"
                            + rowChartDataGrouped.getSumTotal());
                    categoriesSet.add(rowChartDataGrouped.getPurchaseDate());
                    groupedBySet.add(rowChartDataGrouped.getNameGroupedBy());
                });

                categoriesList = (ArrayList<String>)categoriesSet.stream().collect(Collectors.toList());

                //turning sets into maps for identifying with an orden
                categoriesSet.stream().forEach(i -> {
                    //logger.info("every element categoriesSet: " + categoriesMap.size() + " : " + i);
                    categoriesMap.put( i, categoriesMap.size());
                });  //counting from zero
                groupedBySet.stream().forEach(i -> {
                    //logger.info("every element groupedBySet: " + groupedByMap.size() + " : " + i);
                    groupedByMap.put(i, groupedByMap.size());
                });  //counting from zero

                //forming arrays with data
                double[][] matrixTotals = new double[groupedByMap.size()][categoriesMap.size()];
                double[][] matrixQuantities = new double[groupedByMap.size()][categoriesMap.size()];
                double[][] matrixPrices = new double[groupedByMap.size()][categoriesMap.size()];

                logger.info(msjTx + "categoriesMap.size() " + categoriesMap.size());
                logger.info(msjTx + "groupedByMap.size() " + groupedByMap.size());
                logger.info(msjTx + "Probando 1 " + "getChartsData");

                //fill the matrix
                int valueGroupedByMap = 0;
                int valueCategoriesMap = 0;
                for(RowChartDataGrouped rowChartDataGrouped :rowChartDataGroupedList){
                    valueGroupedByMap = groupedByMap.get(rowChartDataGrouped.getNameGroupedBy());
                    valueCategoriesMap = categoriesMap.get(rowChartDataGrouped.getPurchaseDate());
                    logger.info(msjTx + "matrixTotals[" + valueGroupedByMap + "][" + valueCategoriesMap + "]: " + rowChartDataGrouped.getSumTotal());
                    logger.info(msjTx + "matrixQuantities[" + valueGroupedByMap + "][" + valueCategoriesMap + "]: " + rowChartDataGrouped.getSumQuantity());
                    logger.info(msjTx + "matrixPrices[" + valueGroupedByMap + "][" + valueCategoriesMap + "]: " + rowChartDataGrouped.getAvgPrice());
                    matrixTotals[valueGroupedByMap][valueCategoriesMap] = rowChartDataGrouped.getSumTotal() != null ? rowChartDataGrouped.getSumTotal().doubleValue() : null;
                    matrixQuantities[valueGroupedByMap][valueCategoriesMap] = rowChartDataGrouped.getSumQuantity() != null ? rowChartDataGrouped.getSumQuantity().doubleValue() : null;
                    matrixPrices[valueGroupedByMap][valueCategoriesMap] = rowChartDataGrouped.getAvgPrice() != null ? rowChartDataGrouped.getAvgPrice().doubleValue() : null;
                }

                logger.info(msjTx + "Probando 2 " + "getChartsData");

                for (HashMap.Entry<String, Integer> entry : groupedByMap.entrySet()) {
                    totalSerie = new SerieDataResponse();;
                    totalSerie.setName(entry.getKey());
                    totalSerie.setData(matrixTotals[entry.getValue()]);
                    totalSeries.add(totalSerie);

                    quantitySerie = new SerieDataResponse();;
                    quantitySerie.setName(entry.getKey());
                    quantitySerie.setData(matrixQuantities[entry.getValue()]);
                    quantitySeries.add(quantitySerie);

                    priceSerie = new SerieDataResponse();;
                    priceSerie.setName(entry.getKey());
                    priceSerie.setData(matrixPrices[entry.getValue()]);
                    priceSeries.add(priceSerie);
                }

                //fill the totalChartData
                totalChartData.setTitleText(Constantes.CHART_TOTAL_TITLE);
                totalChartData.setSubtitleText(Constantes.CHART_TOTAL_SUBTITLE + request.getGroupBy());
                totalChartData.setyAxisText(Constantes.CHART_TOTAL_Y_AXIS);
                totalChartData.setxAxisText(Constantes.CHART_TOTAL_X_AXIS);
                totalChartData.setValueSuffixTooltip(Constantes.CHART_TOTAL_SUFFIX_TOOLTIP);
                totalChartData.setValueDecimalsTooltip(Constantes.CHART_TOTAL_DECIMALS_TOOLTIP);
                totalChartData.setSeries(totalSeries);
                totalChartData.setCategories(categoriesList);

                //fill the quantityChartData
                quantityChartData.setTitleText(Constantes.CHART_QUANTITY_TITLE);
                quantityChartData.setSubtitleText(Constantes.CHART_QUANTITY_SUBTITLE + request.getGroupBy());
                quantityChartData.setyAxisText(Constantes.CHART_QUANTITY_Y_AXIS);
                quantityChartData.setxAxisText(Constantes.CHART_QUANTITY_X_AXIS);
                quantityChartData.setValueSuffixTooltip(Constantes.CHART_QUANTITY_SUFFIX_TOOLTIP);
                quantityChartData.setValueDecimalsTooltip(Constantes.CHART_QUANTITY_DECIMALS_TOOLTIP);
                quantityChartData.setSeries(quantitySeries);
                quantityChartData.setCategories(categoriesList);

                //fill the priceChartData
                priceChartData.setTitleText(Constantes.CHART_PRICE_TITLE);
                priceChartData.setSubtitleText(Constantes.CHART_PRICE_SUBTITLE + request.getGroupBy());
                priceChartData.setyAxisText(Constantes.CHART_PRICE_Y_AXIS);
                priceChartData.setxAxisText(Constantes.CHART_PRICE_X_AXIS);
                priceChartData.setValueSuffixTooltip(Constantes.CHART_PRICE_SUFFIX_TOOLTIP);
                priceChartData.setValueDecimalsTooltip(Constantes.CHART_PRICE_DECIMALS_TOOLTIP);
                priceChartData.setSeries(priceSeries);
                priceChartData.setCategories(categoriesList);

                getChartsDataResponse.setTotal(totalChartData);
                getChartsDataResponse.setQuantity(quantityChartData);
                getChartsDataResponse.setPrice(priceChartData);

                for(RowTableData rowtableData : tableDataList){
                    rowTableDataResponse = new RowTableDataResponse();
                    rowTableDataResponse.setIdPurchase(rowtableData.getIdPurchase());
                    rowTableDataResponse.setPurchaseDate(rowtableData.getPurchaseDate());
                    rowTableDataResponse.setInvoice(rowtableData.getInvoice());
                    rowTableDataResponse.setCustomerRoot(rowtableData.getCustomerRoot());
                    rowTableDataResponse.setCustomerLeaf(rowtableData.getCustomerLeaf());
                    rowTableDataResponse.setProduct(rowtableData.getProduct());
                    rowTableDataResponse.setPackSize(rowtableData.getPackSize());
                    rowTableDataResponse.setUnitType(rowtableData.getUnitType());
                    rowTableDataResponse.setCategory(rowtableData.getCategory());
                    rowTableDataResponse.setDistributorRoot(rowtableData.getDistributorRoot());
                    rowTableDataResponse.setDistributorLeaf(rowtableData.getDistributorLeaf());
                    rowTableDataResponse.setManufacturer(rowtableData.getManufacturer());
                    rowTableDataResponse.setQuantity(rowtableData.getQuantity());
                    rowTableDataResponse.setPrice(rowtableData.getPrice());
                    rowTableDataResponse.setTotal(rowtableData.getTotal());
                    tableDataResponseList.add(rowTableDataResponse);
                }

                getChartsDataResponse.setTable(tableDataResponseList);

                responseStatus.setCodigoRespuesta(Constantes.OK);
                responseStatus.setMensajeRespuesta(Constantes.EJECUCION_EXITOSA);

            }else{
                logger.info(msjTx + "entra idf2 2: ");
                responseStatus.setCodigoRespuesta(propertiesExternos.dashboard_principal_Idf2_Codigo);
                responseStatus.setMensajeRespuesta(propertiesExternos.dashboard_principal_Idf2_Mensaje);
            }

            responseStatus.setIdTransaccion(headerRequest.getIdTransaccion());
            response.setResponseAudit(responseStatus);
            response.setResponseData(getChartsDataResponse);

        }catch(DBException dbEx){
            responseStatus.setCodigoRespuesta(dbEx.getCode());
            responseStatus.setMensajeRespuesta(dbEx.getMessage());
            response.setResponseAudit(responseStatus);

        } catch (Exception ex) {
            logger.error(msjTx + Constantes.MENSAJERROR + ex.getMessage(), ex);
            throw new Exception(ex.getMessage());
        }

        return response;
    }


}
