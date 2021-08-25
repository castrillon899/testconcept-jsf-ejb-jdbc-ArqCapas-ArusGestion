package com.arus.usuario;

public class AdministradoraDePension {
	
	private String codigo;
	private String descripcion;
	public String getCodigo() {
		return codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	
	public AdministradoraDePension() {
		
	}
	
	public AdministradoraDePension(String codigo, String descripcion) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "TipoDeDocumento [codigo=" + codigo + ", descripcion=" + descripcion + "]";
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
