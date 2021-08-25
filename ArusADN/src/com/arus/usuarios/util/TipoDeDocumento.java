package com.arus.usuarios.util;






public class TipoDeDocumento {
	
	private String codigo;
	private String descripcion;
	public String getCodigo() {
		return codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	
	public TipoDeDocumento() {
		
	}
	
	public TipoDeDocumento(String codigo, String descripcion) {
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
