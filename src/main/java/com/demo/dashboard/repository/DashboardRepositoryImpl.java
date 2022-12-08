package com.demo.dashboard.repository;



import com.demo.dashboard.repository.model.*;
import com.demo.dashboard.utility.exception.DBException;
import com.demo.dashboard.utility.property.PropertiesExternos;
import com.demo.dashboard.utility.request.GetChartsDataByFilterRequest;
import java.text.SimpleDateFormat;
import com.demo.dashboard.utility.util.SearchFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.*;

@Service
public class DashboardRepositoryImpl implements DashboardRepository {

    private static final Logger logger = LoggerFactory.getLogger(DashboardRepositoryImpl.class);
    private static final SimpleDateFormat DF = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private PropertiesExternos propertiesExternos;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<RowChartDataGrouped> getChartsDataGrouped(String mensajeTransaccion, GetChartsDataByFilterRequest request) throws DBException, SQLException {

        logger.info(mensajeTransaccion + " ====== [Inicio] getChartsDataGrouped====== ");

        String sqlList = "";
        String sqlFiltering = "";
        String searchSortField="P.DA_PURCHASE";
        String sqlIdGroupedBy = "";
        String sqlIdRelatedIsdPurchase = "";
        String sqlNameColumnGroupedBy = "";
        String sqlTableColumnGroupedBy = "";

        SearchFilter searchFilter = new SearchFilter();
        if (null != request.getInvoice() && !request.getInvoice().isEmpty()) searchFilter.setInvoice("P.NU_INVOICE");
        if (null != request.getInitialPurchaseDate()) searchFilter.setInitialPurchaseDate("P.DA_PURCHASE");
        if (null != request.getFinalPurchaseDate()) searchFilter.setFinalPurchaseDate("P.DA_PURCHASE");
        if (null != request.getIdProduct()) searchFilter.setIdProduct("PD.ID_PRODUCT");
        if (null != request.getIdCustomerRoot()) searchFilter.setIdCustomerRoot("CR.ID_CUSTOMER_ROOT");
        if (null != request.getIdCustomerLeaf()) searchFilter.setIdCustomerLeaf("CL.ID_CUSTOMER_LEAF");
        if (null != request.getIdPackSize()) searchFilter.setIdPackSize("PS.ID_PACK_SIZE");
        if (null != request.getIdUnitType()) searchFilter.setIdUnitType("UT.ID_UNIT_TYPE");
        if (null != request.getIdCategory()) searchFilter.setIdCategory("C.ID_CATEGORY");
        if (null != request.getIdDistributorRoot()) searchFilter.setIdDistributorRoot("DR.ID_DISTRIBUTOR_ROOT");
        if (null != request.getIdDistributorLeaf()) searchFilter.setIdDistributorLeaf("DL.ID_DISTRIBUTOR_LEAF");
        if (null != request.getIdManufacturer()) searchFilter.setIdManufacturer("M.ID_MANUFACTURER");

        if(null != request.getGroupBy() && !request.getGroupBy().isEmpty()){
            if(request.getGroupBy().equals("product")) {
                sqlIdGroupedBy="PD.ID_PRODUCT";
                sqlIdRelatedIsdPurchase="ID_PRODUCT";
                sqlNameColumnGroupedBy="PD.NA_PRODUCT";
                sqlTableColumnGroupedBy="ISD_PRODUCT PD";
            }else if(request.getGroupBy().equals("customerRoot")) {
                sqlIdGroupedBy="CR.ID_CUSTOMER_ROOT";
                sqlIdRelatedIsdPurchase="ID_CUSTOMER_ROOT";
                sqlNameColumnGroupedBy="CR.NA_CUSTOMER_ROOT";
                sqlTableColumnGroupedBy="ISD_CUSTOMER_ROOT CR";
            }else if(request.getGroupBy().equals("customerLeaf")) {
                sqlIdGroupedBy="CL.ID_CUSTOMER_LEAF";
                sqlIdRelatedIsdPurchase="ID_CUSTOMER_LEAF";
                sqlNameColumnGroupedBy="CL.NA_CUSTOMER_LEAF";
                sqlTableColumnGroupedBy="ISD_CUSTOMER_LEAF CL";
            }else if(request.getGroupBy().equals("packSize")) {
                sqlIdGroupedBy="PS.ID_PACK_SIZE";
                sqlIdRelatedIsdPurchase="ID_PACK_SIZE";
                sqlNameColumnGroupedBy="PS.NA_PACK_SIZE";
                sqlTableColumnGroupedBy="ISD_PACK_SIZE PS";
            }else if(request.getGroupBy().equals("unitType")) {
                sqlIdGroupedBy="UT.ID_UNIT_TYPE";
                sqlIdRelatedIsdPurchase="ID_UNIT_TYPE";
                sqlNameColumnGroupedBy="UT.NA_UNIT_TYPE";
                sqlTableColumnGroupedBy="ISD_UNIT_TYPE UT";
            }else if(request.getGroupBy().equals("category")) {
                sqlIdGroupedBy="C.ID_CATEGORY";
                sqlIdRelatedIsdPurchase="ID_CATEGORY";
                sqlNameColumnGroupedBy="C.NA_CATEGORY";
                sqlTableColumnGroupedBy="ISD_CATEGORY C";
            }else if(request.getGroupBy().equals("distributorRoot")) {
                sqlIdGroupedBy="DR.ID_DISTRIBUTOR_ROOT";
                sqlIdRelatedIsdPurchase="ID_DISTRIBUTOR_ROOT";
                sqlNameColumnGroupedBy="DR.NA_DISTRIBUTOR_ROOT";
                sqlTableColumnGroupedBy="ISD_DISTRIBUTOR_ROOT DR";
            }else if(request.getGroupBy().equals("distributorLeaf")) {
                sqlIdGroupedBy="DL.ID_DISTRIBUTOR_LEAF";
                sqlIdRelatedIsdPurchase="ID_DISTRIBUTOR_LEAF";
                sqlNameColumnGroupedBy="DL.NA_DISTRIBUTOR_LEAF";
                sqlTableColumnGroupedBy="ISD_DISTRIBUTOR_LEAF DL";
            }else if(request.getGroupBy().equals("manufacturer")) {
                sqlIdGroupedBy="M.ID_MANUFACTURER";
                sqlIdRelatedIsdPurchase="ID_MANUFACTURER";
                sqlNameColumnGroupedBy="M.NA_MANUFACTURER";
                sqlTableColumnGroupedBy="ISD_MANUFACTURER M";
            }
        }

        //Filtering
        if (null != searchFilter.getInvoice() && !searchFilter.getInvoice().isEmpty()){
            sqlFiltering= "AND	" + searchFilter.getInvoice() + " LIKE UPPER(" + " '%"  + request.getInvoice() + "%') ";
        }

        if (null != searchFilter.getInitialPurchaseDate() && !searchFilter.getInitialPurchaseDate().isEmpty()){
            sqlFiltering= sqlFiltering + " AND	" + searchFilter.getInitialPurchaseDate() + " >= TO_DATE('" + DF.format(request.getInitialPurchaseDate()) +  "','YYYY-MM-DD') " ;
        }

        if (null != searchFilter.getInitialPurchaseDate() && !searchFilter.getFinalPurchaseDate().isEmpty()){
            sqlFiltering= sqlFiltering + " AND	" + searchFilter.getFinalPurchaseDate() + " <= TO_DATE('" + DF.format(request.getFinalPurchaseDate()) +  "','YYYY-MM-DD') " ;
        }

        if (null != searchFilter.getIdProduct() && !searchFilter.getIdProduct().isEmpty()){
            sqlFiltering= sqlFiltering + " AND	" + searchFilter.getIdProduct() + " = "  + request.getIdProduct() +  " " ;
        }

        if (null != searchFilter.getIdCustomerRoot() && !searchFilter.getIdCustomerRoot().isEmpty()){
            sqlFiltering= sqlFiltering + " and	" + searchFilter.getIdCustomerRoot() + " = " + request.getIdCustomerRoot() +  " " ;
        }

        if (null != searchFilter.getIdCustomerLeaf() && !searchFilter.getIdCustomerLeaf().isEmpty()){
            sqlFiltering= sqlFiltering + " and	" + searchFilter.getIdCustomerLeaf() + " = " + request.getIdCustomerLeaf() +  " " ;
        }

        if (null != searchFilter.getIdPackSize() && !searchFilter.getIdPackSize().isEmpty()){
            sqlFiltering= sqlFiltering + " and	" + searchFilter.getIdPackSize() + " = " + request.getIdPackSize() +  " " ;
        }

        if (null != searchFilter.getIdUnitType() && !searchFilter.getIdUnitType().isEmpty()){
            sqlFiltering= sqlFiltering + " and	" + searchFilter.getIdUnitType() + " = " + request.getIdUnitType() +  " " ;
        }

        if (null != searchFilter.getIdCategory() && !searchFilter.getIdCategory().isEmpty()){
            sqlFiltering= sqlFiltering + " and	" + searchFilter.getIdCategory() + " = " + request.getIdCategory() +  " " ;
        }

        if (null != searchFilter.getIdDistributorRoot() && !searchFilter.getIdDistributorRoot().isEmpty()){
            sqlFiltering= sqlFiltering + " and	" + searchFilter.getIdDistributorRoot() + " = " + request.getIdDistributorRoot() +  " " ;
        }

        if (null != searchFilter.getIdDistributorLeaf() && !searchFilter.getIdDistributorLeaf().isEmpty()){
            sqlFiltering= sqlFiltering + " and	" + searchFilter.getIdDistributorLeaf() + " = " + request.getIdDistributorLeaf() +  " " ;
        }

        if (null != searchFilter.getIdManufacturer() && !searchFilter.getIdManufacturer().isEmpty()){
            sqlFiltering= sqlFiltering + " and	" + searchFilter.getIdManufacturer() + " = " + request.getIdManufacturer() +  " " ;
        }

        sqlList=
                "SELECT TO_CHAR(P.DA_PURCHASE,'MM-DD-YYYY') DA_PURCHASE, " + sqlNameColumnGroupedBy + " NA_GROUPED_BY, " +
                "       SUM(P.AM_QUANTITY) SUM_AM_QUANTITY, ROUND(AVG(P.AM_PRICE),2) AVG_AM_PRICE, SUM(P.AM_TOTAL) SUM_AM_TOTAL " +
                "FROM ISD_PURCHASE P " +
                "INNER JOIN " + sqlTableColumnGroupedBy + " ON P." + sqlIdRelatedIsdPurchase + " = " + sqlIdGroupedBy + " " +
                "WHERE 1 = 1 " + sqlFiltering +
                "GROUP BY " + searchSortField + ", " + sqlNameColumnGroupedBy + " " +
                "ORDER BY " + searchSortField + ", " + sqlNameColumnGroupedBy + " " ;

        logger.info(mensajeTransaccion + "query: " + sqlList);

        List<RowChartDataGrouped> rowChartDataGroupedList = new ArrayList<>();
        rowChartDataGroupedList = jdbcTemplate.query(sqlList.toString(),new RowChartDataGroupedListMapper());

        return rowChartDataGroupedList;

    }

    @Override
    public List<RowTableData> getTableData(String mensajeTransaccion, GetChartsDataByFilterRequest request) throws DBException, SQLException {

        logger.info(mensajeTransaccion + " ====== [Inicio] getTableData====== ");

        String sqlList = "";
        String sqlFiltering = "";
        String sqlSorting = "";
        String searchSortField="P.DA_PURCHASE";

        SearchFilter searchFilter = new SearchFilter();
        if (null != request.getInvoice() && !request.getInvoice().isEmpty()) searchFilter.setInvoice("P.NU_INVOICE");
        if (null != request.getInitialPurchaseDate()) searchFilter.setInitialPurchaseDate("P.DA_PURCHASE");
        if (null != request.getFinalPurchaseDate()) searchFilter.setFinalPurchaseDate("P.DA_PURCHASE");
        if (null != request.getIdProduct()) searchFilter.setIdProduct("PD.ID_PRODUCT");
        if (null != request.getIdCustomerRoot()) searchFilter.setIdCustomerRoot("CR.ID_CUSTOMER_ROOT");
        if (null != request.getIdCustomerLeaf()) searchFilter.setIdCustomerLeaf("CL.ID_CUSTOMER_LEAF");
        if (null != request.getIdPackSize()) searchFilter.setIdPackSize("PS.ID_PACK_SIZE");
        if (null != request.getIdUnitType()) searchFilter.setIdUnitType("UT.ID_UNIT_TYPE");
        if (null != request.getIdCategory()) searchFilter.setIdCategory("C.ID_CATEGORY");
        if (null != request.getIdDistributorRoot()) searchFilter.setIdDistributorRoot("DR.ID_DISTRIBUTOR_ROOT");
        if (null != request.getIdDistributorLeaf()) searchFilter.setIdDistributorLeaf("DL.ID_DISTRIBUTOR_LEAF");
        if (null != request.getIdManufacturer()) searchFilter.setIdManufacturer("M.ID_MANUFACTURER");

        sqlList=
                "SELECT P.ID_PURCHASE, TO_CHAR(P.DA_PURCHASE,'MM-DD-YYYY') DA_PURCHASE, P.NU_INVOICE, " +
                "CR.NA_CUSTOMER_ROOT, CL.NA_CUSTOMER_LEAF, PD.NA_PRODUCT, " +
                "PS.NA_PACK_SIZE, UT.NA_UNIT_TYPE, C.NA_CATEGORY, " +
                "DR.NA_DISTRIBUTOR_ROOT, DL.NA_DISTRIBUTOR_LEAF, M.NA_MANUFACTURER, " +
                "P.AM_QUANTITY, P.AM_PRICE, P.AM_TOTAL " +
                "FROM ISD_PURCHASE P " +
                "INNER JOIN ISD_CUSTOMER_ROOT CR ON P.ID_CUSTOMER_ROOT = CR.ID_CUSTOMER_ROOT " +
                "INNER JOIN ISD_CUSTOMER_LEAF CL ON P.ID_CUSTOMER_LEAF = CL.ID_CUSTOMER_LEAF " +
                "INNER JOIN ISD_PRODUCT PD ON P.ID_PRODUCT = PD.ID_PRODUCT " +
                "INNER JOIN ISD_PACK_SIZE PS ON P.ID_PACK_SIZE = PS.ID_PACK_SIZE " +
                "INNER JOIN ISD_UNIT_TYPE UT ON P.ID_UNIT_TYPE = UT.ID_UNIT_TYPE " +
                "INNER JOIN ISD_CATEGORY C ON P.ID_CATEGORY = C.ID_CATEGORY " +
                "INNER JOIN ISD_DISTRIBUTOR_ROOT DR ON P.ID_DISTRIBUTOR_ROOT = DR.ID_DISTRIBUTOR_ROOT " +
                "INNER JOIN ISD_DISTRIBUTOR_LEAF DL ON P.ID_DISTRIBUTOR_LEAF = DL.ID_DISTRIBUTOR_LEAF " +
                "INNER JOIN ISD_MANUFACTURER M ON P.ID_MANUFACTURER = M.ID_MANUFACTURER " +
                "WHERE 1 = 1 ";

        //Filtering
        if (null != searchFilter.getInvoice() && !searchFilter.getInvoice().isEmpty()){
            sqlFiltering= "AND	" + searchFilter.getInvoice() + " LIKE UPPER(" + " '%"  + request.getInvoice() + "%') ";
        }

        if (null != searchFilter.getInitialPurchaseDate() && !searchFilter.getInitialPurchaseDate().isEmpty()){
            sqlFiltering= sqlFiltering + " AND	" + searchFilter.getInitialPurchaseDate() + " >= TO_DATE('" + DF.format(request.getInitialPurchaseDate()) +  "','YYYY-MM-DD') " ;
        }

        if (null != searchFilter.getInitialPurchaseDate() && !searchFilter.getFinalPurchaseDate().isEmpty()){
            sqlFiltering= sqlFiltering + " AND	" + searchFilter.getFinalPurchaseDate() + " <= TO_DATE('" + DF.format(request.getFinalPurchaseDate()) +  "','YYYY-MM-DD') " ;
        }

        if (null != searchFilter.getIdProduct() && !searchFilter.getIdProduct().isEmpty()){
            sqlFiltering= sqlFiltering + " AND	" + searchFilter.getIdProduct() + " = " + request.getIdProduct() +  " " ;
        }

        if (null != searchFilter.getIdCustomerRoot() && !searchFilter.getIdCustomerRoot().isEmpty()){
            sqlFiltering= sqlFiltering + " and	" + searchFilter.getIdCustomerRoot() + " = " + request.getIdCustomerRoot() +  " " ;
        }

        if (null != searchFilter.getIdCustomerLeaf() && !searchFilter.getIdCustomerLeaf().isEmpty()){
            sqlFiltering= sqlFiltering + " and	" + searchFilter.getIdCustomerLeaf() + " = " + request.getIdCustomerLeaf() +  " " ;
        }

        if (null != searchFilter.getIdPackSize() && !searchFilter.getIdPackSize().isEmpty()){
            sqlFiltering= sqlFiltering + " and	" + searchFilter.getIdPackSize() + " = " + request.getIdPackSize() +  " " ;
        }

        if (null != searchFilter.getIdUnitType() && !searchFilter.getIdUnitType().isEmpty()){
            sqlFiltering= sqlFiltering + " and	" + searchFilter.getIdUnitType() + " = " + request.getIdUnitType() +  " " ;
        }

        if (null != searchFilter.getIdCategory() && !searchFilter.getIdCategory().isEmpty()){
            sqlFiltering= sqlFiltering + " and	" + searchFilter.getIdCategory() + " = " + request.getIdCategory() +  " " ;
        }

        if (null != searchFilter.getIdDistributorRoot() && !searchFilter.getIdDistributorRoot().isEmpty()){
            sqlFiltering= sqlFiltering + " and	" + searchFilter.getIdDistributorRoot() + " = " + request.getIdDistributorRoot() +  " " ;
        }

        if (null != searchFilter.getIdDistributorLeaf() && !searchFilter.getIdDistributorLeaf().isEmpty()){
            sqlFiltering= sqlFiltering + " and	" + searchFilter.getIdDistributorLeaf() + " = " + request.getIdDistributorLeaf() +  " " ;
        }

        if (null != searchFilter.getIdManufacturer() && !searchFilter.getIdManufacturer().isEmpty()){
            sqlFiltering= sqlFiltering + " and	" + searchFilter.getIdManufacturer() + " = " + request.getIdManufacturer() +  " " ;
        }

        sqlSorting= " order by " + searchSortField ;
        sqlList = sqlList + sqlFiltering + sqlSorting;

        logger.info(mensajeTransaccion + "query: " + sqlList);

        List<RowTableData> rowTableDataList = new ArrayList<>();
        rowTableDataList = jdbcTemplate.query(sqlList.toString(),new RowTableDataListMapper());

        for(RowTableData rowTableData : rowTableDataList){
            logger.info(mensajeTransaccion + rowTableData.getIdPurchase() + "/" + rowTableData.getPurchaseDate() + "/"
                    + rowTableData.getQuantity() + "/" + rowTableData.getPrice() + "/"
                    + rowTableData.getTotal());
        }

        return rowTableDataList;

    }

}
