package com.epsfamiliar.familibro.model;

public class DataModel {

	private String nit;
	private String razonSocial;
	private String numContrato;
	private String estado;
	private String departamento;
	private String tipoContrato;
	private String codTarifa;
	private String codPropio;
	private String descTarifa;
	private String valor;	

	public DataModel(String nit, String razonSocial, String numContrato, String estado, String departamento,
			String tipoContrato, String codTarifa, String codPropio, String descTarifa, String valor) {
		super();
		this.nit = nit;
		this.razonSocial = razonSocial;
		this.numContrato = numContrato;
		this.estado = estado;
		this.departamento = departamento;
		this.tipoContrato = tipoContrato;
		this.codTarifa = codTarifa;
		this.codPropio = codPropio;
		this.descTarifa = descTarifa;
		this.valor = valor;
	}

	public DataModel(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getNumContrato() {
		return numContrato;
	}

	public void setNumContrato(String numContrato) {
		this.numContrato = numContrato;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getTipoContrato() {
		return tipoContrato;
	}

	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	public String getCodTarifa() {
		return codTarifa;
	}

	public void setCodTarifa(String codTarifa) {
		this.codTarifa = codTarifa;
	}

	public String getCodPropio() {
		return codPropio;
	}

	public void setCodPropio(String codPropio) {
		this.codPropio = codPropio;
	}

	public String getDescTarifa() {
		return descTarifa;
	}

	public void setDescTarifa(String descTarifa) {
		this.descTarifa = descTarifa;
	}
	
	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}
