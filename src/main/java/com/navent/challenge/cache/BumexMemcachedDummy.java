package com.navent.challenge.cache;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.navent.challenge.model.Pedido;

/**
 * 
 * @author Leito
 *
 */
@Component
public class BumexMemcachedDummy implements BumexMemCache {

	@Override
	public Object get(long key) {
		
		Pedido pedido = new Pedido();
		pedido.setId(1L);
		pedido.setMonto(new BigDecimal(15.5));
		pedido.setDescuento(5);
		pedido.setNombre("Remera");
		
		return pedido;
	}

	@Override
	public void set(long key, Object value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(long key) {
		// TODO Auto-generated method stub

	}

}
