package com.exact.bean;

import java.text.DecimalFormat;
import java.util.*;

public class ReporteRecepcionBean {
	private int idProveedor;
	private String proveedor;
	private int asignados;
	private int recogidos;
	private int sinmovimiento;
	private int pendientes;
	private int recogidosatiempo;
	private int recogidosfueraderango;
	private int entregados;
	private int faltantes;
	private int CodigoProveedor;
	private String sArcoHorario;
	private int iMeta;
	private int iResultado;
	private String sIndicador;
	private List<ReporteRecepcionBean> lDetalle;
	DecimalFormat df = new DecimalFormat("#.##");
	private int TipoAgencia;
	
	public int GetVisitados() {
		return recogidos + sinmovimiento;
	}
	
	
	public String getRecogidosPorcentaje() {
		return String.valueOf(Math.round(((double) recogidos / (double) asignados)*10000.0)/100.0) + "%";
	}

	public String RecogidosATiempoPorcentaje() {
		return String.valueOf(Math.round(((double) recogidosatiempo / (double) GetVisitados())*10000.0)/100.0) + "%";
	}

	public String RecogidosFueraRangoPorcentaje() {
		return String.valueOf(Math.round(((double) recogidosfueraderango / (double) GetVisitados())*10000.0)/100.0) + "%";
	}

	public String SinMovimientoPorcentaje() {
		return String.valueOf(Math.round(((double) sinmovimiento / (double) asignados)*10000.0)/100.0) + "%";
	}

	public String VisitadosPorcentaje() {
		return String.valueOf(Math.round(((double) GetVisitados() / (double) asignados)*10000.0)/100.0) + "%";
	}

	public String PendientesPorcentaje() {
		return String.valueOf(Math.round(((double) pendientes / (double) asignados)*10000.0)/100.0) + "%";
	}

	public String EntregadosPorcentaje() {
		return String.valueOf(Math.round(((double) entregados / (double) asignados)*10000.0)/100.0) + "%";
	}

	public String FaltantesPorcentaje() {
		return String.valueOf(Math.round(((double) faltantes / (double) asignados)*10000.0)/100.0) + "%";
	}

	public String sMetaPorcentaje() {
		return String.valueOf(df.format(Math.round(((double) iMeta / (double) 100)*10000.0)/100.0)) + "%";
	}

	public String sResultadoPorcentaje() {
		System.out.println("Resultado : "+iResultado + "\n" +"Asignados : " + asignados );
		return String.valueOf(Math.round(((double) iResultado / (double) asignados)*10000.0)/100.0) + "%";
	}

	public List<ReporteRecepcionBean> getlDetalle() {
		return lDetalle;
	}

	public void setlDetalle(List<ReporteRecepcionBean> lDetalle) {
		this.lDetalle = lDetalle;
	}

	public int getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public int getAsignados() {
		return asignados;
	}

	public void setAsignados(int asignados) {
		this.asignados = asignados;
	}

	public int getRecogidos() {
		return recogidos;
	}

	public void setRecogidos(int recogidos) {
		this.recogidos = recogidos;
	}

	public int getSinmovimiento() {
		return sinmovimiento;
	}

	public void setSinmovimiento(int sinmovimiento) {
		this.sinmovimiento = sinmovimiento;
	}

	public int getPendientes() {
		return pendientes;
	}

	public void setPendientes(int pendientes) {
		this.pendientes = pendientes;
	}

	public int getRecogidosatiempo() {
		return recogidosatiempo;
	}

	public void setRecogidosatiempo(int recogidosatiempo) {
		this.recogidosatiempo = recogidosatiempo;
	}

	public int getRecogidosfueraderango() {
		return recogidosfueraderango;
	}

	public void setRecogidosfueraderango(int recogidosfueraderango) {
		this.recogidosfueraderango = recogidosfueraderango;
	}

	public int getEntregados() {
		return entregados;
	}

	public void setEntregados(int entregados) {
		this.entregados = entregados;
	}

	public int getFaltantes() {
		return faltantes;
	}

	public void setFaltantes(int faltantes) {
		this.faltantes = faltantes;
	}

	public int getCodigoProveedor() {
		return CodigoProveedor;
	}

	public void setCodigoProveedor(int codigoProveedor) {
		CodigoProveedor = codigoProveedor;
	}

	public String getsArcoHorario() {
		return sArcoHorario;
	}

	public void setsArcoHorario(String sArcoHorario) {
		this.sArcoHorario = sArcoHorario;
	}

	public int getiMeta() {
		return iMeta;
	}

	public void setiMeta(int iMeta) {
		this.iMeta = iMeta;
	}

	public int getiResultado() {
		return iResultado;
	}

	public void setiResultado(int iResultado) {
		this.iResultado = iResultado;
	}

	public String getsIndicador() {
		return sIndicador;
	}

	public void setsIndicador(String sIndicador) {
		this.sIndicador = sIndicador;
	}


	public int getTipoAgencia() {
		return TipoAgencia;
	}


	public void setTipoAgencia(int tipoAgencia) {
		TipoAgencia = tipoAgencia;
	}
	

}
