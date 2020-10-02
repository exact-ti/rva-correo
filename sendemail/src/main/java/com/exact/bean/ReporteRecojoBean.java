package com.exact.bean;

public class ReporteRecojoBean {
	private int id;
	private int codigoAgencia;
	private String agencia;
	private String ArcoInferior;
	private String ArcoSuperior;
	private String Proveedor;
	private String Estado;
	private String Indicador;
	private int IdProveedor;
	private int iGrupo;

	public int getIdProveedor() {
		return IdProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		IdProveedor = idProveedor;
	}

	public int getiGrupo() {
		return iGrupo;
	}

	public void setiGrupo(int iGrupo) {
		this.iGrupo = iGrupo;
	}

	private String codigoIndicador;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCodigoAgencia() {
		return codigoAgencia;
	}

	public void setCodigoAgencia(int codigoAgencia) {
		this.codigoAgencia = codigoAgencia;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getArcoInferior() {
		return ArcoInferior;
	}

	public void setArcoInferior(String arcoInferior) {
		ArcoInferior = arcoInferior;
	}

	public String getArcoSuperior() {
		return ArcoSuperior;
	}

	public void setArcoSuperior(String arcoSuperior) {
		ArcoSuperior = arcoSuperior;
	}

	public String getProveedor() {
		return Proveedor;
	}

	public void setProveedor(String proveedor) {
		Proveedor = proveedor;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public String getIndicador() {
		return Indicador;
	}

	public void setIndicador(String indicador) {
		Indicador = indicador;
	}

	public String getCodigoIndicador() {
		return codigoIndicador;
	}

	public void setCodigoIndicador(String codigoIndicador) {
		this.codigoIndicador = codigoIndicador;
	}

}