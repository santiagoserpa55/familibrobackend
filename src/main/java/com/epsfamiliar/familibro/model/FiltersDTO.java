package com.epsfamiliar.familibro.model;

public class FiltersDTO {
	//Crea un objeto para recibir los filtros desde Angular:
	private String busquedaGeneral;
	private String razonSocial;
	private String estado;
	private String tipo;
	private String departamento;
	
	
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getBusquedaGeneral() {
		return busquedaGeneral;
	}
	public void setBusquedaGeneral(String busquedaGeneral) {
		this.busquedaGeneral = busquedaGeneral;
	}
	
}
