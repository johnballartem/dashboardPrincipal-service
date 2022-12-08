package com.demo.dashboard.utility.types;

public class ResponseStatusType {

	private String idTransaccion;
	private String codigoRespuesta;
	private String mensajeRespuesta;

	public ResponseStatusType() {
	}

	public ResponseStatusType(String idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	public void setIdTransaccion(String idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	public String getIdTransaccion() {
		return idTransaccion;
	}

	public void setCodigoRespuesta(String codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}

	public String getCodigoRespuesta() {
		return codigoRespuesta;
	}

	public void setMensajeRespuesta(String mensajeRespuesta) {
		this.mensajeRespuesta = mensajeRespuesta;
	}

	public String getMensajeRespuesta() {
		return mensajeRespuesta;
	}
}