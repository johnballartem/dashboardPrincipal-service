package com.demo.dashboard.utility.request;



import com.demo.dashboard.utility.property.Constantes;
import com.demo.dashboard.utility.util.DashboardUtil;

import javax.validation.constraints.NotNull;
import javax.ws.rs.core.HttpHeaders;
import java.util.Calendar;
import java.util.Date;

public class HeaderRequest {

	@NotNull
	private String idTransaccion;
	@NotNull
	private String msgid;
	@NotNull
	private Date timestamp;
	@NotNull
	private String userId;
	@NotNull
	private String accept;
	@NotNull
	private String aplicacion;

	public HeaderRequest() {
		super();
	}

	public HeaderRequest(HttpHeaders httpHeaders) {
		super();

		this.idTransaccion = httpHeaders.getRequestHeader(Constantes.IDTRANSACCION) != null
				? httpHeaders.getRequestHeader(Constantes.IDTRANSACCION).get(Constantes.NUM_ZERO)
				: null;
		this.msgid = httpHeaders.getRequestHeader(Constantes.MSGID) != null
				? httpHeaders.getRequestHeader(Constantes.MSGID).get(Constantes.NUM_ZERO)
				: null;
		this.aplicacion = httpHeaders.getRequestHeader(Constantes.APLICACION) != null
				? httpHeaders.getRequestHeader(Constantes.APLICACION).get(Constantes.NUM_ZERO)
				: null;
		this.userId = httpHeaders.getRequestHeader(Constantes.USRID) != null
				? httpHeaders.getRequestHeader(Constantes.USRID).get(Constantes.NUM_ZERO)
				: null;
		this.accept = httpHeaders.getRequestHeader(Constantes.ACCEPT) != null
				? httpHeaders.getRequestHeader(Constantes.ACCEPT).get(Constantes.NUM_ZERO)
				: null;
		Calendar a = DashboardUtil.toCalendar(httpHeaders.getRequestHeader(Constantes.TIMESTAMP) != null
				? httpHeaders.getRequestHeader(Constantes.TIMESTAMP).get(Constantes.NUM_ZERO)
				: Constantes.TEXTO_VACIO);
		this.timestamp = new Date();
		if (a != null) {
			this.timestamp = a.getTime();

		}
	}

	public String getAccept() {
		return accept;
	}

	public void setAccept(String accept) {
		this.accept = accept;
	}

	public String getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(String aplicacion) {
		this.aplicacion = aplicacion;
	}

	public String getIdTransaccion() {
		return idTransaccion;
	}

	public void setIdTransaccion(String idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	public String getMsgid() {
		return msgid;
	}

	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "HeaderRequest [idTransaccion=" + idTransaccion + ", msgid=" + msgid + ", timestamp=" + timestamp
				+ ", userId=" + userId + ", accept=" + accept + ", aplicacion=" + aplicacion + "]";
	}

}