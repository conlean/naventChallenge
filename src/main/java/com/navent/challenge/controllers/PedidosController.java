package com.navent.challenge.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.navent.challenge.model.Pedido;
import com.navent.challenge.service.PedidosService;

/**
 * 
 * @author Leito Pedidos controller
 */
@RestController
@RequestMapping("/api")
public class PedidosController {

	private static final Logger logger = LoggerFactory.getLogger(PedidosController.class);
	private final PedidosService pedidosSerivce;

	public PedidosController(PedidosService pedidosSerivce) {
		this.pedidosSerivce = pedidosSerivce;
	}

	@PostMapping("/products")
	public ResponseEntity<Pedido> createProduct(@Valid @RequestBody Pedido pedido) {

		logger.info(String.format("guardando pedido Title: %s ", pedido.getNombre()));

		pedidosSerivce.upsert(pedido);

		return new ResponseEntity<>(pedido, HttpStatus.CREATED);
	}
}
