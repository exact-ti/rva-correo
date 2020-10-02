package com.exact.bean;

public class UsuarioCorreoBean {
	private String sidUsuario;
	private String usuario;
	private String apellido;
	private String correo;
	private String descripcionTipo;
	private String sClave;
	private int iGrupo;
	private int IdProveedor;
	private String correoCC;
	private String alias;

	public int getIdProveedor() {
		return IdProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		IdProveedor = idProveedor;
	}

	public String getSidUsuario() {
		return sidUsuario;
	}

	public void setSidUsuario(String sidUsuario) {
		this.sidUsuario = sidUsuario;
	}

	public String getsClave() {
		return sClave;
	}

	public void setsClave(String sClave) {
		this.sClave = sClave;
	}

	public String getIdUsuario() {
		return sidUsuario;
	}

	public void setIdUsuario(String sidUsuario) {
		this.sidUsuario = sidUsuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDescripcionTipo() {
		return descripcionTipo;
	}

	public void setDescripcionTipo(String descripcionTipo) {
		this.descripcionTipo = descripcionTipo;
	}

	public int getiGrupo() {
		return iGrupo;
	}

	public void setiGrupo(int iGrupo) {
		this.iGrupo = iGrupo;
	}

	public String getCorreoCC() {
		return correoCC;
	}

	public void setCorreoCC(String correoCC) {
		this.correoCC = correoCC;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

}
