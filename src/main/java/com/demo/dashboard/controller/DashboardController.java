package com.demo.dashboard.controller;


import com.demo.dashboard.service.DashboardService;
import com.demo.dashboard.utility.property.Constantes;
import com.demo.dashboard.utility.property.PropertiesExternos;
import com.demo.dashboard.utility.request.*;
import com.demo.dashboard.utility.response.*;
import com.demo.dashboard.utility.types.ResponseStatusType;
import com.demo.dashboard.utility.util.DashboardUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.text.SimpleDateFormat;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.beans.propertyeditors.CustomDateEditor;


@RestController
@RequestMapping(Constantes.BASEPATH)
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class DashboardController {

    private final Logger logger = LoggerFactory.getLogger(DashboardController.class);

    @Autowired
    private PropertiesExternos prop;

    @Autowired
    private DashboardService dashboardService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping (value = Constantes.PATHMETODO_GET_CHARTS_DATA, produces = "application/json")
    public StandardGetChartsDataResponse getChartsData(
            @RequestHeader(name = "idTransaccion", required = true) String idTransaccion,
            @RequestHeader(name = "userId", required = false) String userId,
            @RequestHeader(name = "msgid", required = false) String msgid,
            @RequestHeader(name = "timestamp", required = false) String timestamp,
            @RequestHeader(name = "accept", required = false) String accept,
            @RequestHeader(name = "aplicacion", required = false) String aplicacion,
            @RequestParam String groupBy,
            @RequestParam(name = "invoice", required = false) String invoice,
            @RequestParam(name = "initialPurchaseDate", required = false) Date initialPurchaseDate,
            @RequestParam(name = "finalPurchaseDate", required = false) Date finalPurchaseDate,
            @RequestParam(name = "idProduct", required = false) Integer idProduct,
            @RequestParam(name = "idCustomerRoot", required = false) Integer idCustomerRoot,
            @RequestParam(name = "idCustomerLeaf", required = false) Integer idCustomerLeaf,
            @RequestParam(name = "idPackSize", required = false) Integer idPackSize,
            @RequestParam(name = "idUnitType", required = false) Integer idUnitType,
            @RequestParam(name = "idCategory", required = false) Integer idCategory,
            @RequestParam(name = "idDistributorRoot", required = false) Integer idDistributorRoot,
            @RequestParam(name = "idDistributorLeaf", required = false) Integer idDistributorLeaf,
            @RequestParam(name = "idManufacturer", required = false) Integer idManufacturer
            ) throws JsonProcessingException {

        StandardGetChartsDataResponse response = new StandardGetChartsDataResponse();
        GetChartsDataByFilterRequest request = new GetChartsDataByFilterRequest();

        String requestPrint = null;
        String responsePrint = null;
        long tiempoInicio = System.currentTimeMillis();

        ResponseStatusType responseStatus = new ResponseStatusType();

        HeaderRequest headerRequest = new HeaderRequest();
        headerRequest.setIdTransaccion(idTransaccion);
        headerRequest.setUserId(userId);
        headerRequest.setMsgid(msgid);
        headerRequest.setAccept(accept);
        headerRequest.setTimestamp(new Date());
        headerRequest.setAplicacion(aplicacion);
        String idtx = headerRequest.getIdTransaccion();

        request.setGroupBy(groupBy);
        request.setInvoice(invoice);
        request.setInitialPurchaseDate(initialPurchaseDate);
        request.setFinalPurchaseDate(finalPurchaseDate);
        request.setIdProduct(idProduct);
        request.setIdCustomerRoot(idCustomerRoot);
        request.setIdCustomerLeaf(idCustomerLeaf);
        request.setIdPackSize(idPackSize);
        request.setIdUnitType(idUnitType);
        request.setIdCategory(idCategory);
        request.setIdDistributorRoot(idDistributorRoot);
        request.setIdDistributorLeaf(idDistributorLeaf);
        request.setIdManufacturer(idManufacturer);

        String msjTx = Constantes.CHAR_CORCHETE_IZQUIERDO + Constantes.GET_CHARTS_DATA + Constantes.ID_TXT + idtx
                + Constantes.MSG_ID + msgid + Constantes.CORCHETE;
        logger.info(msjTx + Constantes.SEPARADOR);
        logger.info(msjTx + Constantes.INICIO_METODO + Constantes.GET_CHARTS_DATA);
        logger.info(msjTx + Constantes.SEPARADOR);

        try {
            requestPrint = DashboardUtil.printPrettyJSONString(request);
            logger.info(msjTx + Constantes.PARAMETROSENTRADA);
            logger.info(msjTx + Constantes.PARAMETROSHEADER + Constantes.SALTO_LINEA
                    + DashboardUtil.printPrettyJSONString(headerRequest));
            logger.info(msjTx + Constantes.PARAMETROSBODY + Constantes.SALTO_LINEA + requestPrint);
            logger.info(msjTx + Constantes.PARAMETROSOBLIGATORIOS);
            logger.info(msjTx + Constantes.VALIDACIONPARAMETROSCORRECTOS);

            if (!this.validaCuerpoGetChartsData(request)) {
                responseStatus.setIdTransaccion(idTransaccion);
                responseStatus.setCodigoRespuesta(prop.dashboard_principal_Idf1_Codigo);
                responseStatus.setMensajeRespuesta(prop.dashboard_principal_Idf1_Mensaje);
                response.setResponseAudit(responseStatus);

            }else {
                response = dashboardService.getChartsData(msjTx, headerRequest, request);
            }

        } catch (Exception e) {
            responseStatus.setCodigoRespuesta(prop.dashboard_principal_Idt3_Codigo);
            responseStatus.setMensajeRespuesta(prop.dashboard_principal_Idt3_Mensaje + Constantes.ESPACIO + e.getMessage());
            responseStatus.setIdTransaccion(idtx);
            response.setResponseAudit(responseStatus);
        } finally {
            responsePrint = DashboardUtil.printPrettyJSONString(response);
            logger.info(msjTx + Constantes.DEVOLVERRESPONSE + Constantes.SALTO_LINEA + responsePrint);
            logger.info(msjTx + Constantes.SEPARADOR);
            logger.info(msjTx + Constantes.FIN_METODO + Constantes.GET_CHARTS_DATA + Constantes.TIEMPO_TOTAL
                    + (System.currentTimeMillis() - tiempoInicio) + Constantes.MILISEGUNDOS);
            logger.info(msjTx + Constantes.SEPARADOR);
        }
        return response;

    }

    private boolean validaCuerpoGetChartsData(GetChartsDataByFilterRequest request) {
        boolean valida = true;
        if(request.getGroupBy().equals("")){
            valida = false;
        }
        return valida;
    }


}
