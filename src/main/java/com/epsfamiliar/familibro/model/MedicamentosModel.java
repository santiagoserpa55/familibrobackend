package com.epsfamiliar.familibro.model;

public class MedicamentosModel {
	private String cum;
	private String atc;
	private String descripcion;
	private String tarifaOferta;
	private String estado;

	public MedicamentosModel(String cum, String atc, String descripcion, String tarifaOferta, String estado) {
		super();
		this.cum = cum;
		this.atc = atc;
		this.descripcion = descripcion;
		this.tarifaOferta = tarifaOferta;
		this.estado = estado;
	}

  // Métodos estáticos de fábrica
  public static MedicamentosModel porCum(String cum) {
      return new MedicamentosModel(cum, null, null, null, null);
  }

  public static MedicamentosModel porAtc(String atc) {
      return new MedicamentosModel(null, atc, null, null, null);
  }

	public String getCum() {
		return cum;
	}

	public void setCum(String cum) {
		this.cum = cum;
	}

	public String getAtc() {
		return atc;
	}

	public void setAtc(String atc) {
		this.atc = atc;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTarifaOferta() {
		return tarifaOferta;
	}

	public void setTarifaOferta(String tarifaOferta) {
		this.tarifaOferta = tarifaOferta;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
