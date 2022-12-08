package com.demo.dashboard.utility.util;


import com.demo.dashboard.utility.property.Constantes;
import com.demo.dashboard.utility.property.PropertiesExternos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.HttpHeaders;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class DashboardUtil {
	private static final Logger log = LoggerFactory.getLogger(DashboardUtil.class);

	PropertiesExternos propertiesExternos;

	public static String getAllHttpHeaders(HttpHeaders httpHeaders) {
		StringBuffer data = new StringBuffer();

		Set<String> headerKeys = httpHeaders.getRequestHeaders().keySet();
		for (String header : headerKeys) {
			data.append(header + ":" + httpHeaders.getRequestHeader(header).get(Constantes.NUM_ZERO) + "\n");
		}
		return data.toString().trim();
	}
/*
	public static HttpURLConnection connectionHttpRest(HttpURLConnection connection, HeaderRequest header,
													   String metodo) throws ProtocolException {
		connection.setRequestMethod(metodo);
		DateFormat hourdateFormat = new SimpleDateFormat(Constantes.FORMATOFECHACABECERA);
		String ts = hourdateFormat.format(header.getTimestamp());

		connection.setRequestProperty(Constantes.ACCEPT, Constantes.APPLICATION_JSON);
		connection.setRequestProperty(Constantes.IDTRANSACCION, header.getIdTransaccion());
		connection.setRequestProperty(Constantes.MSGID, header.getMsgid());
		connection.setRequestProperty(Constantes.TIMESTAMP, ts);
		connection.setRequestProperty(Constantes.USRID, header.getUserId());
		connection.setRequestProperty(Constantes.CONTENTTYPE, Constantes.APPLICATION_JSON);
		connection.setRequestProperty(Constantes.APLICACION, header.getAplicacion());
		return connection;
	}

	public static HttpURLConnection connectionHttpRestCBIO(HttpURLConnection connection, HeaderRequest header,
														   String metodo, PropertiesExternos prop) throws ProtocolException {
		connection.setRequestMethod(metodo);

		if (header.getTimestamp() != null) {
			DateFormat hourdateFormat = new SimpleDateFormat(Constantes.FORMATOFECHACABECERA);
			String ts = hourdateFormat.format(header.getTimestamp());
			connection.setRequestProperty(Constantes.FECHAINICIO, ts);
		}
		// connection.setRequestProperty(Constantes.CANAL,
		// prop.consultaDetalleContratoCbioHeaderCanal);
		// connection.setRequestProperty(Constantes.IDAPLICACION,
		// prop.consultaDetalleContratoCbioHeaderIdAplicacion);
		connection.setRequestProperty(Constantes.USUARIOAPLICACION, header.getUserId());
		connection.setRequestProperty(Constantes.USUARIOSESION, header.getUserId());
		connection.setRequestProperty(Constantes.IDTRANSACCIONNEGOCIO, header.getIdTransaccion());
		connection.setRequestProperty(Constantes.CONTENTTYPE, Constantes.APPLICATION_JSON);
		connection.setRequestProperty(Constantes.ACCEPT, Constantes.APPLICATION_JSON);

		return connection;
	}*/

	public static String getHttpHeadersIdTransaccion(HttpHeaders httpHeaders) {

		String idTransaccion = httpHeaders.getRequestHeader(Constantes.IDTRANSACCION) != null
				? httpHeaders.getRequestHeader(Constantes.IDTRANSACCION).get(0)
				: "";

		StringBuffer data = new StringBuffer();
		data.append(Constantes.LEFT_CLASP + Constantes.IDTRANSACCION + "=");
		data.append(idTransaccion);
		data.append(Constantes.RIGHT_CLASP);
		return data.toString();
	}

	public static String getHttpHeadersNoNull(HttpHeaders httpHeaders) {

		String idTransaccion = httpHeaders.getRequestHeader(Constantes.IDTRANSACCION) != null
				? httpHeaders.getRequestHeader(Constantes.IDTRANSACCION).get(0)
				: "";
		String msgid = httpHeaders.getRequestHeader(Constantes.MSGID) != null
				? httpHeaders.getRequestHeader(Constantes.MSGID).get(0)
				: "";
		String timestamp = "";
		Calendar a = DashboardUtil.toCalendar(httpHeaders.getRequestHeader(Constantes.TIMESTAMP) != null
				? httpHeaders.getRequestHeader(Constantes.TIMESTAMP).get(0).toString()
				: Constantes.TEXTO_VACIO);
		if (a != null) {
			timestamp = a.getTime().toString();
		}
		String userId = httpHeaders.getRequestHeader(Constantes.USRID) != null
				? httpHeaders.getRequestHeader(Constantes.USRID).get(0)
				: "";
		String accept = httpHeaders.getRequestHeader(Constantes.ACCEPT) != null
				? httpHeaders.getRequestHeader(Constantes.ACCEPT).get(0)
				: "";
		StringBuffer data = new StringBuffer();
		data.append("[" + Constantes.IDTRANSACCION + "=");
		data.append(idTransaccion);
		data.append(" " + Constantes.MSGID + "=");
		data.append(msgid);
		data.append(" " + Constantes.TIMESTAMP + "=");
		data.append(timestamp);
		data.append(" " + Constantes.USRID + "=");
		data.append(userId);
		data.append(" " + Constantes.ACCEPT + "=");
		data.append(accept);
		data.append(Constantes.CHAR_CORCHETE_IZQUIERDO);
		return data.toString();
	}

	public static String getHttpHeaders(HttpHeaders httpHeaders) {

		if (httpHeaders.getRequestHeader(Constantes.IDTRANSACCION) == null) {
			return null;
		}
		if (httpHeaders.getRequestHeader(Constantes.MSGID) == null) {
			return null;
		}
		if (httpHeaders.getRequestHeader(Constantes.TIMESTAMP) == null) {
			return null;
		}
		if (httpHeaders.getRequestHeader(Constantes.USRID) == null) {
			return null;
		}

		String idTransaccion = httpHeaders.getRequestHeader(Constantes.IDTRANSACCION) != null
				? httpHeaders.getRequestHeader(Constantes.IDTRANSACCION).get(0)
				: "";
		String msgid = httpHeaders.getRequestHeader(Constantes.MSGID) != null
				? httpHeaders.getRequestHeader(Constantes.MSGID).get(0)
				: "";
		String timestamp = httpHeaders.getRequestHeader(Constantes.TIMESTAMP) != null
				? httpHeaders.getRequestHeader(Constantes.TIMESTAMP).get(0)
				: "";
		String userId = httpHeaders.getRequestHeader(Constantes.USRID) != null
				? httpHeaders.getRequestHeader(Constantes.USRID).get(0)
				: "";

		StringBuffer data = new StringBuffer();
		data.append("[" + Constantes.IDTRANSACCION + "=");
		data.append(idTransaccion);
		data.append(" " + Constantes.MSGID + "=");
		data.append(msgid);
		data.append(" " + Constantes.TIMESTAMP + "=");
		data.append(timestamp);
		data.append(" " + Constantes.USRID + "=");
		data.append(userId);
		data.append(" " + Constantes.ACCEPT + "=");
		data.append(httpHeaders.getMediaType());
		data.append(Constantes.CHAR_CORCHETE_IZQUIERDO);
		return data.toString();
	}

	public static String getExceptionToMensaje(Exception e) {
		String msg = Constantes.TEXTO_VACIO;
		if (e.getCause() != null) {
			msg = e.getCause().toString();
		} else {
			msg = e.toString();
		}
		return msg;
	}

	public static DateFormat getLocalFormat() {
		DateFormat dateFormat = new SimpleDateFormat(Constantes.FORMATOFECHACABECERA);
		dateFormat.setTimeZone(TimeZone.getDefault());
		return dateFormat;
	}

	public static String printPrettyJSONString(Object o) throws JsonProcessingException {
		return new ObjectMapper().setDateFormat(DashboardUtil.getLocalFormat())
				.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false).writerWithDefaultPrettyPrinter()
				.writeValueAsString(o);
	}

	public static String printJSONString(Object o) {
		try {
			return new ObjectMapper().setDateFormat(DashboardUtil.getLocalFormat())
					.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false).writeValueAsString(o);
		} catch (JsonProcessingException e) {
			log.error("Ocurrio un error al convertir JSON", e);
			return Constantes.TEXTO_VACIO;
		}
	}

	public static String nuloAVacio(Object object) {

		if (object == null) {
			return Constantes.TEXTO_VACIO;
		} else {
			return object.toString();
		}
	}

	public static Object nuloAVacioObject(Object object) {
		if (object == null) {
			return Constantes.TEXTO_VACIO;
		} else {
			return object;
		}
	}

	public static String verifiyNull(Object object) {
		String a = null;
		if (object != null) {
			a = object.toString();
		}
		return a;
	}

	public static String convertProperties(Object object) {
		String a = null;
		if (object != null) {
			a = object.toString();
			try {
				a = new String(a.getBytes(Constantes.DEFAULTENCONDIGPROPERTIES), Constantes.DEFAULTENCONDINGAPI);
			} catch (Exception e) {
				log.error("Error getProperties Encoding Failed, trayendo Encoding por defecto", e);
			}
		}
		return a;
	}

	public static Integer convertirInteger(Object object) {

		Integer res = null;
		if (object != null) {
			if (object instanceof BigDecimal) {
				BigDecimal bd = (BigDecimal) object;
				res = bd.intValueExact();
			} else {
				log.error(object.getClass().getSimpleName());
			}
		}
		return res;
	}

	public static Float convertirFloat(Object object) {
		Float res = null;
		if (object != null) {
			if (object instanceof BigDecimal) {
				BigDecimal bd = (BigDecimal) object;
				res = bd.floatValue();
			}
		}
		return res;
	}

	/**
	 * Genera un String a partir de un Date, si fecha es NULL retorna "" (vacio).
	 *
	 * @param fecha tipo Date
	 * @return String de la forma dd/MM/yyyy
	 */
	public static String dateAString(Date fecha) {
		if (fecha == null) {
			return Constantes.TEXTO_VACIO;
		}
		return dateAString(fecha, Constantes.FORMATOFECHACABECERA);
	}

	/**
	 * Genera un String a partir de un Date de acuerdo al fomrato enviado, si fecha
	 * es NULL toma la fecha actual.
	 *
	 * @param fecha
	 * @param formato
	 * @return
	 */
	public static String dateAString(Date fecha, String formato) {

		if (fecha != null) {
			SimpleDateFormat formatoDF = new SimpleDateFormat(formato, Locale.ROOT);
			return formatoDF.format(fecha);
		} else {
			return null;
		}

	}

	public static Calendar toCalendar(final String iso8601string) {
		Calendar calendar = GregorianCalendar.getInstance();
		String s = iso8601string.replace("Z", "+00:00");
		try {
			s = s.substring(0, 22) + s.substring(23); // to get rid of the ":"
			Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.ROOT).parse(s);
			calendar.setTime(date);
		} catch (IndexOutOfBoundsException e) {
			log.error("Ocurrio un error al recorrer la cadena de Fecha", e);
			calendar = null;
		} catch (ParseException e) {
			log.error("Ocurrio un error al convertir a Date la cadena de la fecha", e);
			calendar = null;
		}
		return calendar;
	}

	public static boolean isValidFormat(String format, String value) {
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.ROOT);
			date = sdf.parse(value);
			if (!value.equals(sdf.format(date))) {
				date = null;
			}
		} catch (ParseException ex) {
			date = null;
		}
		return date != null;
	}

	public static Date getValidFormatDate(String format, String value) {
		Date date = null;
		if (value != null && !value.isEmpty()) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.ROOT);
				date = sdf.parse(value);
				if (!value.equals(sdf.format(date))) {
					date = null;
				}
			} catch (ParseException ex) {
				date = null;
			}
		}
		return date;
	}

	public static Date stringADate(String fecha, String formatoFecha) {
		Date fechaGenerada = null;
		if (fecha != null) {
			try {
				SimpleDateFormat formato = new SimpleDateFormat(formatoFecha);
				fechaGenerada = formato.parse(fecha);
			} catch (Exception e) {
				log.error("Error al formatear fecha :" + fecha, e);
			}
		}

		return fechaGenerada;
	}

	public static String transformacion(String properties, String request) {
		String salida = "";
		String array[] = properties.split("\\|");

		for (String objeto : array) {

			String otro[] = objeto.split("\\:");

			for (int i = 0; i < otro.length; i++) {
				if (request.equals(otro[0])) {
					salida = otro[1];
				}
			}

		}
		return salida;

	}

	public static XMLGregorianCalendar convertDateToGregorianCalendar(Date fecha) {
		GregorianCalendar calender = new GregorianCalendar();
		calender.setTime(fecha);

		try {
			return DatatypeFactory.newInstance().newXMLGregorianCalendarDate(calender.get(Calendar.YEAR),
					calender.get(Calendar.MONTH) + 1, calender.get(Calendar.DAY_OF_MONTH),
					DatatypeConstants.FIELD_UNDEFINED);
		} catch (DatatypeConfigurationException e) {
			log.error("Error al modificar fecha : " + fecha, e);
			e.printStackTrace();
		}
		return null;
	}

	public static boolean devolverValoresConfigurables(String datoBuscar, String variableProperties) {
		boolean flagEncontroTipo = false;
		String[] arregloDatos = new String[1];
		String[] tipos = variableProperties.split(Constantes.BUSCARPIPELINE);
		log.info("Se buscar la informacion para el siguiente dato: " + datoBuscar);
		log.info("Se buscar en el siguiente bloque: " + variableProperties);

		for (String bean : tipos) {
			String[] datosFin = bean.split("|");
			if (datosFin[0].equals(datoBuscar)) {
				arregloDatos = datosFin;
				log.info("datos" + datosFin[0] + "comparar" + datoBuscar);
				flagEncontroTipo = true;
				break;
			}
		}
		if (!flagEncontroTipo) {
			log.info("No se encontro el dato a buscar " + datoBuscar);
		}
		return flagEncontroTipo;
	}

	public static boolean recorrerSplit(String stringBuscar, String datoABuscar, String caracter) {

		boolean resultado = false;
		String[] parts = stringBuscar.split(caracter);
		for (int i = 0; i < parts.length; i++) {

			if (parts[i].equals(datoABuscar)) {
				resultado = true;
				break;
			}

		}

		return resultado;
	}

	public static boolean MayorValoresConfigurables(Integer datoBuscar, String variableProperties) {
		boolean flagEncontroTipo = false;
		String[] arregloDatos = null;
		String[] tipos = variableProperties.split(Constantes.BUSCARPIPELINE);
		log.info("Se buscar la informacion para el siguiente dato: " + datoBuscar);
		log.info("Se buscar en el siguiente bloque: " + variableProperties);
		for (String bean : tipos) {
			String[] datosFin = bean.split("|");
			if (Integer.parseInt(datosFin[0]) > datoBuscar) {

				flagEncontroTipo = true;
				break;
			}
		}
		if (!flagEncontroTipo) {
			log.info("No se encontro el dato a buscar " + datoBuscar);
		}
		return flagEncontroTipo;
	}

	public static String convertProp(Object object) {
		String a = null;
		if (object != null) {
			a = object.toString();
			try {
				a = new String(a.getBytes(Constantes.DEFAULTENCONDIGPROPERTIES), Constantes.DEFAULTENCONDINGAPI);
			} catch (Exception e) {
				log.error("Error getProperties Encoding Failed, trayendo Encoding por defecto", e);
			}
		}
		return a;
	}

	public static String getStoredProcedureByParameters(Object owner, Object packg, Object name) {
		StringBuffer storedProcedure = new StringBuffer();
		if (owner != null && !owner.toString().isEmpty()) {
			storedProcedure.append(owner.toString());
			storedProcedure.append(Constantes.SEPARADORPUNTO);
		}
		if (packg != null && !packg.toString().isEmpty()) {
			storedProcedure.append(packg.toString());
			storedProcedure.append(Constantes.SEPARADORPUNTO);
		}
		if (name != null && !name.toString().isEmpty()) {
			storedProcedure.append(name.toString());
		}
		return storedProcedure.toString();
	}

	public static String getStoredProcedureByParameters(Object owner, Object name) {
		StringBuffer storedProcedure = new StringBuffer();
		if (owner != null && !owner.toString().isEmpty()) {
			storedProcedure.append(owner.toString());
			storedProcedure.append(Constantes.SEPARADORPUNTO);
		}
		if (name != null && !name.toString().isEmpty()) {
			storedProcedure.append(name.toString());
		}
		return storedProcedure.toString();
	}

	public static String obtnerIp() {
		String ip = Constantes.TEXTO_VACIO;
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (Exception e) {
			log.error("Error al obtener IP: " + e.getMessage(), e);
		}
		return ip;
	}

	public static XMLGregorianCalendar toXMLGregorianCalendarTimeStamp(Timestamp timeStamp)
			throws DatatypeConfigurationException {
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(timeStamp);
		return DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
	}

	public static XMLGregorianCalendar toXMLGregorianCalendarDate(Date timeStamp)
			throws DatatypeConfigurationException {
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(timeStamp);
		return DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
	}

	public static String getNroDocumento(String idTypeCode, String paramTipoDoc, String tipoDoc) {
		String[] parts = paramTipoDoc.split(Constantes.PUNTO_COMA);
		String tipoDocumento = Constantes.TEXTO_VACIO;
		for (int i = 0; i < parts.length; i++) {
			String[] parts3 = parts[i].split(Constantes.PALOTE);
			if (parts3[0].substring(0).equals(idTypeCode)) {
				tipoDocumento = parts3[2];
			}
		}
		if (tipoDocumento.equals(Constantes.TEXTO_VACIO)) {
			tipoDocumento = tipoDoc;
		}
		return tipoDocumento;
	}

	/* Cambios JGQP 30/11/2019 */
	public static TreeMap<String, String> obtenerMapReemplazos(String cadenaValores, String delimitadorRegistros,
															   String delimitadorCampos) {
		TreeMap<String, String> mapReemplazo = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
		try {
			String strReemplazo = cadenaValores;
			if (strReemplazo != null && !strReemplazo.isEmpty()) {
				String[] arrayReemplazoBolsas = strReemplazo.split(delimitadorRegistros);
				String strNombre;
				String strNombreReemplazo;
				for (int i = 0; i < arrayReemplazoBolsas.length; i++) {
					strNombre = arrayReemplazoBolsas[i].split(delimitadorCampos)[0];
					strNombreReemplazo = arrayReemplazoBolsas[i].split(delimitadorCampos)[1];
					mapReemplazo.put(strNombre, strNombreReemplazo);
				}
			}
		} catch (Exception e) {
			log.error("Error al obtener el Map de Reemplazos: [" + cadenaValores + "]", e);
		}
		return mapReemplazo;
	}

	public static Date parseXMLGregorianCalendarToDate(XMLGregorianCalendar xml) {
		Date date = null;
		if (xml != null) {
			date = xml.toGregorianCalendar().getTime();
		}
		return date;
	}

	public static String getFormatDateBalance(Date date) {
		String strDate = "";
		try {
			SimpleDateFormat f = new SimpleDateFormat(Constantes.FORMATOFECHABALANCE);
			strDate = f.format(new Date());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strDate;
	}

	public static XMLGregorianCalendar getXmlGCFechaSistema(Date date, String strFormato) throws Exception {
		DateFormat format = new SimpleDateFormat(strFormato);
		XMLGregorianCalendar gDateFormatted1 = DatatypeFactory.newInstance()
				.newXMLGregorianCalendar(format.format(date));
		return gDateFormatted1;
	}
/*
	public static HttpURLConnection connectionHttp(HttpURLConnection connection, HeaderRequest header)
			throws ProtocolException {
		connection.setRequestMethod("POST");
		DateFormat hourdateFormat = new SimpleDateFormat(Constantes.FORMATOFECHACABECERA);
		String ts = hourdateFormat.format(header.getTimestamp());

		connection.setRequestProperty(Constantes.ACCEPTT, Constantes.APPLICATION_JSON);
		connection.setRequestProperty(Constantes.IDTRANSACCION, header.getIdTransaccion());
		connection.setRequestProperty(Constantes.MSGID, header.getMsgid());
		connection.setRequestProperty(Constantes.TIMESTAMP, ts);
		connection.setRequestProperty(Constantes.USRID, header.getUserId());
		connection.setRequestProperty(Constantes.CONTENTTYPE, Constantes.APPLICATION_JSON);
		return connection;
	}*/

	public static String obtIpServidor(String msjTx) {
		String localIpAddress;
		String ipservidor = Constantes.TEXTO_VACIO;
		try {
			localIpAddress = InetAddress.getLocalHost().getHostAddress();
			InetAddress.getAllByName(localIpAddress);
			ipservidor = localIpAddress;
		} catch (UnknownHostException e) {
			log.info(msjTx, e);
		}
		return ipservidor;
	}

	public static String obtNombreServidor(String msjTx) {
		String nombrehost = Constantes.TEXTO_VACIO;
		try {
			String localIpAddress = InetAddress.getLocalHost().getHostAddress();
			InetAddress.getAllByName(localIpAddress);
			InetAddress addr = InetAddress.getByName(localIpAddress);
			String hostname = addr.getHostName();
			nombrehost = hostname;
		} catch (UnknownHostException e) {
			log.info(msjTx, e);
		}
		return nombrehost;
	}

	public static String validacionFechaAsignacion(String fechaAsignacion) {
		String resultado = Constantes.TEXTO_VACIO;
		if (!fechaAsignacion.equals(Constantes.TEXTO_VACIO)) {
			resultado = fechaAsignacion;
		} else {
			DateFormat hourdateFormat = new SimpleDateFormat(Constantes.FORMATOFECHA);
			String ts = hourdateFormat.format(new Date());
			resultado = ts;
		}
		return resultado;
	}

	public static Date getCicloFecha(String ciclo, boolean entro) {
		Date date = new Date();
		Date currentDate = null;
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		if (entro) {
			localDate = localDate.minusMonths(1);
		}
		int year = localDate.getYear();
		int month = localDate.getMonthValue();
		int day = localDate.getDayOfMonth();
		String strFecha = day + Constantes.SLASH + month + Constantes.SLASH + year;

		SimpleDateFormat sd = new SimpleDateFormat(Constantes.FORMATFECHA);
		try {
			currentDate = sd.parse(strFecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currentDate;
	}

	public static String retornaNumeroFormateado(String s) {
		String strRespuesta = Constantes.TEXTO_VACIO;
		if (s.indexOf(Constantes.CCOMA) != Constantes.NEGUNO) {
			int contador = 0;
			String invertida = Constantes.TEXTO_VACIO;
			for (int indice = s.length() - 1; indice >= 0; indice--) {
				if (contador < 1 && s.charAt(indice) == ',') {
					contador++;
					invertida += Constantes.PUNTO;
				} else {
					invertida += s.charAt(indice);
				}
			}
			for (int indice = invertida.length() - 1; indice >= 0; indice--) {
				strRespuesta += invertida.charAt(indice);
			}
		} else {
			strRespuesta = s;
		}
		return strRespuesta;
	}

	public static int getMesDeFecha(String fecha) {
		int month = 0;
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		try {
			date = formato.parse(fecha);
			LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			month = localDate.getMonthValue();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return month;
	}

	public static int getMesDeFecha(Date date) {
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int month = localDate.getMonthValue();
		return month;
	}

}