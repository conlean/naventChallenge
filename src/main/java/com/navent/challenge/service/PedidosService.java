package com.navent.challenge.service;

import com.navent.challenge.model.Pedido;

/**
 * 
 * @author Leito
 *
 */

public interface PedidosService {

	void upsert(Pedido pedido);

	Pedido get(long id);

	void delete(long id);
}
