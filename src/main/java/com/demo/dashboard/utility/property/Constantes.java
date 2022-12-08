package com.demo.dashboard.utility.property;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Constantes {

	public static final String GET_CHARTS_DATA = "Search Charts Data";
	public static final String EJECUCION_EXITOSA = "Ejecucion exitosa";
	public static final String VALIDA_LOGIN = "Validate Login";

	public static final String CORCHETE = "]";
	public static final String PARAMETROSOBLIGATORIOS = "----0. Validar parametros obligatorios ------";


	public static final String REQUEST = "$request";
	public static final String RESPONSE = "$response";
	public static final String DATOS_SERVICIO = " Datos Enviados a Servicio : $request";
	public static final String RESPUESTA_SERVICIO = " Respuesta del Servicio : $response";
	public static final String SI_REGISTROS = "::::::::SI se encontraron registros en: [mensaje]::::::::";
	public static final String NO_REGISTROS = "::::::::No se encontraron registros en; [mensaje]::::::::";
	public static final String SLASH = "/";
	public static final String COMA = ",";
	public static final char CCOMA = ',';
	public static final String STRLINEAVALIDAR = "$strLineaValidar";
	public static final String CONSMENSAJEESPERANDO = "$consMensajeEsperandoRespuesta";
	public static final String PEDIDO = "$pedido";
	public static final String LLAVECERO = "$0";
	public static final String LLAVEUNO = "$1";
	public static final String PGUION = "(_p)";
	public static final String BGUION = "(_b)";
	public static final String PSINGUION = "(p)";
	public static final String BSINGUION = "(b)";
	public static final String PINICIAL = "<p>";
	public static final String BINICIAL = "<b>";
	public static final String PFINAL = "</p>";
	public static final String BFINAL = "</b>";
	public static final String C = "|C|";
	public static final String P = "|P|";
	public static final int DOS = 2;
	public static final String SALTO_LINEA = "\n";
	public static final String CONTENTTYPE = "Content-Type";
	public static final String APPLICATION_JSON = "application/json";
	public static final Integer UNO_INT = 1;
	public static final String TRANSACTION_ID = " idTx=";
	public static final String VARIABLE_DB = "$bd";
	public static final String VARIABLE_SP = "$sp";
	public static final String VARIABLE_MT = "$met";
	public static final String VARIABLE_WS = "$ws";
	public static final String FLAGBACKOUT = "consFlagBlackOut";
	public static final String MSG_ID = " msgid=";
	public static final String CADENA_CERO = "0";
	public static final String CADENA_01 = "01";
	public static final int TRES = 3;
	public static final String URL = "URL:";
	public static final String REQUESTHEADER = "RequestHeader:";
	public static final String REQUESTBODY = "RequestBody:";
	public static final String CADENA_UNO = "1";
	public static final String CADENA_DOS = "2";
	public static final String CADENA_TRES = "3";
	public static final String EXCEPCION_REST = " Excepcion ocurrida en la WS - REST ";
	public static final String DOSPUNTOS = ":";
	public static final String EXCEPTION_WS_TIMEOUT_01 = "timed out";
	public static final String EXCEPTION_WS_TIMEOUT_02 = "SocketTimeoutException";
	public static final String EXCEPTION_WS_NO_DISPONIBLE_01 = "RemoteAccessException";
	public static final String EXCEPTION_WS_NO_DISPONIBLE_02 = "404";
	public static final String EXCEPTION_WS_NO_DISPONIBLE_03 = "WebServiceException";
	public static final String EXCEPTION_WS_NO_DISPONIBLE_04 = "ConnectException";
	public static final String SEPARATOR = "=========================================================================================";
	public static final String SEP = "=============================";
	public static final String LEFT_CLASP = " [";
	public static final String EX_CON_CORCHETE = "$ex";
	public static final String VALIDACIONCORRECTA = "[Validacion es Correcta]";
	public static final String VALIDACIONCORRECTASALDOINICIAL = "[Validacion es Correcta - Saldo Inicial es mayor al monto]";

	public static final String RIGHT_CLASP = "]";
	public static final String ACCOUNTVALUE1 = "accountValue1";
	public static final String RESPONSECODE = "responseCode";
	public static final String VERSION = "1.0.0";
	public static final String EJBEXCEPTION = "EJBException ";
	public static final String MENSAJEIDF = "[IDF CONTROLADO]: ";
	public static final String HEADER_PARAMS = " Parametros del Header:";
	public static final String EMPTY_TEXT = "";
	public static final String BODY_VALIDATION = "Validacion del Header/Body";
	public static final String ZERO = "0";
	public static final String ZUNO = "1";
	public static final String ZDOS = "2";
	public static final BigInteger BIUNO =new BigInteger("1");
	public static final String NOMBRESERVICIO = "$servicio";
	public static final String OPERACION = "$operacion";
	public static final String NOMBRESP = "$nombre_SP";
	public static final String NOMBREJNDI = "$nombre_JNDI";
	public static final String NOMBREWS = "$nombre_WS";
	public static final String NOMBREURL = "$nombre_URL";
	public static final int STATUSTIMEOUT = 504;
	public static final String INICIO_ACTIVIDAD = " [Inicio]";
	public static final String WS = " WS ";
	public static final String FIN_ACTIVIDAD = " [Fin] ";
	public static final int STATUSDISPONIBILIDAD = 404;
	public static final String EXCEPTIONWSTIMEOUT01 = "timed out";
	public static final String EXCEPTIONWSTIMEOUT02 = "SocketTimeoutException";
	public static final String CHARSETUTF8 = ";charset=UTF-8";
	public static final String CONNECTINTERNALTIMEOUT = "com.sun.xml.internal.ws.connect.timeout";
	public static final String REQUESTINTERNALTIMEOUT = "com.sun.xml.internal.ws.request.timeout";
	public static final String CONNECTTIMEOUT = "com.sun.xml.ws.connect.timeout";
	public static final String REQUESTTIMEOUT = "com.sun.xml.ws.request.timeout";

	public static final String FORMATOFECHAZH = "yyyyMMdd'T'HH:mm:ssZZZZ";
	public static final String FORMATOGTM = "America/Lima";
	public static final String MENSAJERROR = "[ERROR]: ";
	public static final String MENSAJERPTA = "[MENSAJE]: ";
	public static final String RESPUESTA = "RESPUESTA: ";
	public static final String ERROREX = "[$ex]";
	public static final String MENSAJE = "mensaje";
	public static final String MILISEGUNDOS = "milisegundos";
	public static final String SPACE = " ";
	public static final String FINMETODO = "[ FIN de metodo ";
	public static final String TIEMPOTOTAL = " ] Tiempo total de proceso (ms):";
	public static final String EXCEPTIONWSRESTTIMEOUT01 = "SocketTimeoutException";
	public static final String EXCEPTIONWSRESTTIMEOUT02 = "timed out";
	public static final String IDENTIFICADORWSCONCORCHETE = "[$ws]";
	public static final String IDENTIFICADOROPCONCORCHETE = "[$op]";
	public static final String ERROREXCEPTIONGENERADO = "Error [Exception] generado: ";
	public static final String CHARPARENTESISIZQUIERDO = "(";
	public static final String CHARPARENTESISDERECHO = ")";
	public static final String CHARCORCHETEIZQUIERDO = " [";
	public static final String CHARCORCHETEDERECHO = "] ";
	public static final String CHARCORCHETEPUNTOS = ": [";
	public static final String CHARINTERROGACION = "?";
	public static final String ERRORFUNCIONAL = "Hubo error funciona con el $recurso";
	public static final String ERRORDATA = "Hubo error de Data al setear $recurso";
	public static final String RECURSO = "$recurso";
	public static final String CADENAINICIOMETODO = "[INICIO] - METODO: [";
	public static final String CADENAFINMETODO = "[FIN] - METODO: [";
	public static final String DEVOLVERRESPONSE = " Response a devolver:";

	public static final String METODOINICIO = " Inicio Metodo: ";
	public static final String METODO = "Metodo :";
	public static final String BASEPATH = "dashboardPrincipal/";
	public static final String PATHMETODO_GET_CHARTS_DATA = "/getChartsData";

	public static final String CHART_TOTAL_TITLE = "Total Purchase";
	public static final String CHART_TOTAL_SUBTITLE = "Total Purchase per ";
	public static final String CHART_TOTAL_Y_AXIS = "United States dollars ($ USD US$)";
	public static final String CHART_TOTAL_X_AXIS = "Days";
	public static final String CHART_TOTAL_SUFFIX_TOOLTIP = " USD";
	public static final int CHART_TOTAL_DECIMALS_TOOLTIP = 2;

	public static final String CHART_QUANTITY_TITLE = "Quantity";
	public static final String CHART_QUANTITY_SUBTITLE = "Quantity per ";
	public static final String CHART_QUANTITY_Y_AXIS = "Unities";
	public static final String CHART_QUANTITY_X_AXIS = "Days";
	public static final String CHART_QUANTITY_SUFFIX_TOOLTIP = " units";
	public static final int CHART_QUANTITY_DECIMALS_TOOLTIP = 0;

	public static final String CHART_PRICE_TITLE = "Price";
	public static final String CHART_PRICE_SUBTITLE = "Price per ";
	public static final String CHART_PRICE_Y_AXIS = "United States dollars ($ USD US$)";
	public static final String CHART_PRICE_X_AXIS = "Days";
	public static final String CHART_PRICE_SUFFIX_TOOLTIP = " USD";
	public static final int CHART_PRICE_DECIMALS_TOOLTIP = 2;
	public static final String DATAAUDIT = "dataAudit";
	public static final String SEPARADOR = "=========================================================================================";

	public static final String CHARSET = ";charset=UTF-8";
	public static final String HEADERREQUEST = "Header Request: ";
	public static final String BODYREQUEST = "Body Request: ";
	public static final String PARAMETROSENTRADA = "Parametros de entrada: ";
	public static final String ID_TXT = " idTx=";

	public static final String TIEMPO_TOTAL = " ] Tiempo total de proceso (ms): ";
	public static final String TEXTOURLSERVICIO = " Url Servicio : ";
	public static final String PARAMETROSSALIDA = " Parametros de salida: ";
	public static final String PARAMETROSHEADER = " Header Request:";
	public static final String PARAMETROSBODY = "Body Request: ";
	public static final String MENOSUNO = "-1";
	public static final String CANALVALOR = "CAC";
	public static final String TEXTOUSRAPLICACION = "usuarioAplicacion";
	public static final String USRSESION = "usuarioSesion";
	public static final String RESPONSEBODY = "ResponseBody:";
	public static final String VALIDACIONPARAMETROSCORRECTOS = " Validacion correcta de parametros de entrada";
	public static final String VALIDACIONPARAMETROSINCORRECTOS = " Parametros de entrada no cumple validacion";
	public static final String DATOSSALIDA = "Datos de salida: ";
	public static final String DATOSENVIADO = "Datos Enviados a Servicio :";
	public static final String VALORESRESPUESTA = "Valores de Respuesta : ";
	// --------
	public static final String SEPARADORPUNTO = ".";
	public static final String FORMATOFECHACABECERA = "yyyy-MM-dd'T'HH:mm:ss'Z'";
	public static final String FORMATOFECHABALANCE =  "yyyyMMdd'T'HH:mm:ssZ";	
	public static final String FORMATOFECHA = "yyyy-MM-dd'T'HH:mm:ss";
	public static final String FORMATOFECHA_1 = "yyyy-MM-dd HH:mm:ss";
	public static final String FORMATFECHA = "dd/MM/yyyy";
	public static final String FORMATFECHA2 = "dd-MM-yyyy";
	                                        
	public static final String ID = "id";	
	// --------Format Mensaje---------
	public static final String PRINT_INSUMO_BD = "%s insumo SP:%s en base datos:%s, en JNDI:%s";
	public static final String PRINT_INSUMO_WS = "%s insumo metodo:%s en servicio:%s, Timeout Conexion: %d ms, Timeout Ejecucion: %d ms, URL:%s";
	public static final String PRINT_HEADER = "%s Datos Header: %s";
	public static final String PRINT_DATA_IN = "%s Datos de Envio: %s";
	public static final String PRINT_DATA_OUT = "%s Datos de Salida: %s";
	public static final String PRINT_DATA_ITEM_S = "%s - %s: [%s]";
	public static final String PRINT_DATA_ITEM_N = "%s - %s: [%d]";
	public static final String PRINT_STATUS_HTTP = "%s - Status: %d";
	public static final String PRINT_INSUMO = "%s[%s]";
	public static final String PRINT_INSUMO_INI = "%s - Inicio insumo [%s]";
	public static final String PRINT_INSUMO_FIN = "%s - Fin insumo [%s], tiempo de ejecucion: %d ms.";

	// --------Request---------
	public static final String IDTRANSACCION = "idTransaccion";
	public static final String APLICACION = "aplicacion";
	public static final String MSGID = "msgid";
	public static final String USRID = "userId";
	
	public static final String CANAL = "canal";
	public static final String IDAPLICACION = "idAplicacion";
	public static final String USUARIOAPLICACION = "usuarioAplicacion";
	public static final String USUARIOSESION = "usuarioSesion";
	public static final String IDTRANSACCIONNEGOCIO = "idTransaccionNegocio";
	public static final String FECHAINICIO = "fechaInicio";
	
	public static final String IDTRANSACCIONESB = "idTransaccionESB";
	public static final String NODOADICIONAL = "nodoAdicional";
	public static final String TIMESTAMP = "timestamp";
	public static final String ACCEPT = "accept";
	
 
	public static final String IPAPLICACION = "ipAplicacion";
	public static final String NOMBAPLICACION = "nombreAplicacion";
	public static final String ACCEPTT = "Accept";
	public static final String API = "api";
	public static final String CHAR_CORCHETE_IZQUIERDO = " [";
	// -----------------
	public static final String PROPERTIESINTERNOS = "config.properties";
	public static final String PROPERTIESEXTERNOS = ".properties";
	public static final String PROPERTIESKEY = "claro.properties";
	public static final String CONSTANTENOJNDI = "javax.persistence.PersistenceException";
	public static final String CONSTANTENOJNDIWS = "MessageBodyProviderNotFoundException";
	public static final String CONSTANTETIMEOUTWS = "java.net.SocketTimeoutException";
	public static final int NUM_ZERO = 0;
	public static final int NUM_UNO = 1;
	public static final int NUM_SEIS = 6;
	public static final int NUM_SIETE = 7;

	public static final String UNO = "1";
	public static final String DEFAULTENCONDIGPROPERTIES = null;
	public static final String DEFAULTENCONDINGAPI = null;
	public static final String FORMATO_FECHA_SP = null;
	public static final String CONNECT_TIMEOUT = "com.sun.xml.internal.ws.connect.timeout";
	public static final String REQUEST_TIMEOUT = "com.sun.xml.internal.ws.request.timeout";

	public static final String INICIO_METODO = " INICIO METODO: ";
	public static final String FIN_METODO = " FIN METODO: ";
	public static final String FININSUMO = " FIN INSUMO: ";
	public static final String INI = " INICIO: ";
	public static final String FIN= " FIN: ";
	public static final String ESPACIO = " ";
	public static final String IGUAL = "=";
	public static final String BUSCARPIPELINE = "\\|";
	public static final String EMPTY = "";
	public static final String CHAR_CORCHETE_DERECHO = "] ";
	public static final String MILISEG = " milisegundos.";
	public static final String INI_CORCHETE1 = " 1. [";
	public static final String PALOTE = "|";
	public static final String PUNTO_COMA = ";";
	public static final String TEXTOESPACIO = " ";
	public static final String EXCEPTIONWSNODISPONIBLE01 = "RemoteAccessException";
	public static final String EXCEPTIONWSNODISPONIBLE02 = "404";
	public static final String EXCEPTIONWSNODISPONIBLE03 = "WebServiceException";
	public static final String EXCEPTIONWSNODISPONIBLE04 = "ConnectException";
	public static final String TIMEOUTEXCEPTION = "Timeout";
	public static final String TIMEOUTEXCEPTION2 = "Timed out";
	public static final String CONFIGPROPERTIES = "config.properties";
	public static final String SWAGGERJAXRSCONFIG = "SwaggerJaxrsConfig";
	public static final String URLSWAGGERJAXRSCONFIG = "/SwaggerJaxrsConfig";
	public static final String HTML5CORSFILTER = "HTML5CorsFilter";
	public static final String URLPATTERNS = "/api/*";
	public static final String ACCESSCONTROLALLOWORIGIN = "Access-Control-Allow-Origin";
	public static final String ACCESSCONTROLALLOWMETHODS = "Access-Control-Allow-Methods";
	public static final String ACCESSCONTROLALLOWHEADERS = "Access-Control-Allow-Headers";
	public static final String ASTERISCO = "*";
	public static final String METODOSPERMITIDOS = "GET, POST, DELETE, PUT";

	// --------------------------------------------------------------
	public static final String ERROR_CONVERSION = "Error en la conversi�n ... ";
	public static final String VALUE_COR = "] value = [";
	public static final String COR_DERECHA = "] ";
	public static final String ERROR_PARSE_XML = "Error parseando object to xml:";
	public static final String COR_GUION = "] - [";
	public static final String GUION = " - ";
	public static final String ERROR_COR = "ERROR: [";
	public static final String CONECTIONSERVICIO = "Conectando con el servicio";
	// ---------------------------------------------------------//
	public static final String TXT_OK = "OK";
	public static final String TXT_ERROR = "ERROR";
	public static final String ERROR = "1";
	public static final String OK = "0";
	public static final String codCanal = "03";
	public static final String METODOPOST = "POST";
	public static final String ERROR_EXCEPTION = "Error Exception: ";

	public static final String REPLACEHEADERUTF8XML = "<?xml version=\"1.0\" encoding=\"UTF-16\"?>";
	public static final String COMPONENTE = "Componente: ";
	public static final String REPLACEMETHODCALL = "methodCall";
	public static final String RESPONSE_BODY = " ResponseBody: ";
	public static final String ERRORENCLIENTE = "Ocurrio un error en el cliente ";
	public static final String TEXTO_VACIO = "";
	public static final String TIMEOUT = "Timeout";
	public static final String ERRORDETIMEOUT = "Ocurrio un error tecnico de tipo TimeOut";
	public static final String CODIGOERROR = " Codigo de Error: ";
	public static final String MENSAJEERROR = " Mensaje del error: ";
	public static final String ERRORDEDISPONIBILIDAD = "Ocurrio un error tecnico de tipo Disponibilidad";
	public static final String REPLACE_COMPONENTE = "[#COMPONENTE]";
	public static final String REPLACE_METODO = "[#METODO]";
	public static final String REPLACE_DETALLE = "[#DETALLE]";
	
	public static final String CHANNEL = "channel";
	public static final String IDBUSINESSTRANSACTION = "idBusinessTransaction";
	public static final String IDTRANSACTIONESB = "idTransaccionESB";
	public static final String USERSESSION = "userSession";
	public static final String USERAPPLICATION = "userApplication";
	public static final String MENSAJE_ERROR = "[error]";
	public static final String NUMINTERNACIONAL="51";

	public static final String REPLACE_PARAMETROS = "$parametros";
	
	
    public final static String SALTOLINEA = "\n";
    public final static char PUNTO = '.';
    public static final int NZ_UNO=-1;   
    public static final int NUM_TRES=3;    
    public static final int LINEA_INACTIVA=3;    
    public static final BigDecimal BGCERO=new BigDecimal("0");;    


    public static final String IDF0 = "IDF0";
    public static final String IDFV = "IDFV";
    public static final String IDT = "IDT";

    public static final String TRUE="true";
    public static final String FALSE="false";
    public static final String FORMATO_FECHA_YMD_HMS="yyyy-MM-dd HH:mm:ss.SSS";
    public static final int NEGUNO=-1;
    public static final String RESP_SIN_DATOS="Response sin datos";
    public static final String FORCE = "FORCE";
    

    public static final String EJECUTO_CORRECTO =  "Se ejecuto correctamente";
    public static final String ACTIVIDAD1 = "------- 1. List Customers by filter ------------";
	public final static String POSTGRESQL_DRIVER = "org.postgresql.Driver";
	public final static String CANNOT_GET_CONNECTION = "Cannot get connection: ";
	public static final String CONSULTAINICIO = " Consulta Inicio : ";
    public static final String PARAMOUTPUT = " PARAMETROS [OUTPUT]: ";
	public static final String TEXTONOMBREBD = " BASE DE DATOS : ";
    public static final String TEXTOUSUARIO = " USUARIO : ";
	public static final String TEXTOERRORTIMEOUT = "[Error De TimeOut en: ";
	public static final String TEXTOERRORDISPONIBILIDAD = "[Error De Disponibilidad en ] ";
	public static final String PARAMINPUT = " PARAMETROS [INPUT]: ";
    public static final String SQLTIMEOUTEXCEPTION = "SQLTIMEOUTEXCEPTION";
   
}