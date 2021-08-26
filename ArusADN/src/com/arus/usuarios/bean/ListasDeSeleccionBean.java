package com.arus.usuarios.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.arus.usuarios.util.AdministradoraDePension;
import com.arus.usuarios.util.AdministradoraDeSalud;
import com.arus.usuarios.util.TipoDeDocumento;

@ManagedBean(name="parametrizador")
@RequestScoped
public class ListasDeSeleccionBean {

	private List<TipoDeDocumento> tiposDedocumentos;
	private List<AdministradoraDeSalud> administradoraDeSalud;
	private List<AdministradoraDePension> administradoraDePension;
	
	public ListasDeSeleccionBean() {
		cargarTipoDeDocumentos();
		cargarAdministradoraDeSalud();
		cargarAdministradoraDePension();
	}

	private void cargarTipoDeDocumentos()
	{
		tiposDedocumentos=new ArrayList<>();
		tiposDedocumentos.add(new TipoDeDocumento("CC","Cédula"));
		tiposDedocumentos.add(new TipoDeDocumento("CE","Cédula de extranjería"));
		tiposDedocumentos.add(new TipoDeDocumento("RC","Registro Civil"));
		tiposDedocumentos.add(new TipoDeDocumento("TI","Tarjeta de Identidad"));
	}
	
	
	private void cargarAdministradoraDeSalud()
	{
		administradoraDeSalud=new ArrayList<>();
		administradoraDeSalud.add(new AdministradoraDeSalud("EPS001","Sanitas EPS"));
		administradoraDeSalud.add(new AdministradoraDeSalud("EPS002","Sura EPS"));
		administradoraDeSalud.add(new AdministradoraDeSalud("EPS003","Coomeva"));
		administradoraDeSalud.add(new AdministradoraDeSalud("EPS004","Medimas"));
	}
	
	
	private void cargarAdministradoraDePension()
	{
		administradoraDePension=new ArrayList<>();
		administradoraDePension.add(new AdministradoraDePension("AFP001","Protección"));
		administradoraDePension.add(new AdministradoraDePension("AFP002","Porvenir"));
		administradoraDePension.add(new AdministradoraDePension("AFP003","Colpensiones"));
	}
	
	public List<TipoDeDocumento> getTiposDedocumentos() {
		return tiposDedocumentos;
	}

	public void setTiposDedocumentos(List<TipoDeDocumento> tiposDedocumentos) {
		this.tiposDedocumentos = tiposDedocumentos;
	}
	
	

	public void setAdministradoraDeSalud(List<AdministradoraDeSalud> administradoraDeSalud) {
		this.administradoraDeSalud = administradoraDeSalud;
	}

	public List<AdministradoraDeSalud> getAdministradoraDeSalud() {
		return administradoraDeSalud;
	}

	

	public List<AdministradoraDePension> getAdministradoraDePension() {
		return administradoraDePension;
	}

	public void setAdministradoraDePension(List<AdministradoraDePension> administradoraDePension) {
		this.administradoraDePension = administradoraDePension;
	}

	@Override
	public String toString() {
		return "Parametrizador [tiposDedocumentos=" + tiposDedocumentos + "]";
	}

	
	
}
