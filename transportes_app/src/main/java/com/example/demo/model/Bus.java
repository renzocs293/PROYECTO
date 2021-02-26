package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_BUS")
public class Bus implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id_bus;
	private String placa;
	private Integer cap_estandar;
	private String cap_premiun;
	
	@ManyToOne
	@JoinColumn(name = "id_fabricante")
	private Fabricante fabricante;
	
	public Integer getId_bus() {
		return id_bus;
	}
	public void setId_bus(Integer id_bus) {
		this.id_bus = id_bus;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public Integer getCap_estandar() {
		return cap_estandar;
	}
	public void setCap_estandar(Integer cap_estandar) {
		this.cap_estandar = cap_estandar;
	}
	public String getCap_premiun() {
		return cap_premiun;
	}
	public void setCap_premiun(String cap_premiun) {
		this.cap_premiun = cap_premiun;
	}
	public Fabricante getFabricante() {
		return fabricante;
	}
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
}
