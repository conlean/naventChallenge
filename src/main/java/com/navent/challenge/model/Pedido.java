package com.navent.challenge.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author Leito
 *
 */
public class Pedido {

	private Long id;

	@NotNull(message = "Debe ingresar una descripcion")
	@Size(max = 100, message = "Supera los 100 caracteres el nombre")
	private String nombre;

	@NotNull(message = "Debe ingresar un monto")
	private BigDecimal monto;

	private Integer descuento;

	public Pedido() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public Integer getDescuento() {
		return descuento;
	}

	public void setDescuento(Integer descuento) {
		this.descuento = descuento;
	}

}
