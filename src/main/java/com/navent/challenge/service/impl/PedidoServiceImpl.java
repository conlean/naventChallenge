/**
 * 
 */
package com.navent.challenge.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.navent.challenge.cache.BumexMemcachedDummy;
import com.navent.challenge.dao.PedidoDAO;
import com.navent.challenge.model.Pedido;
import com.navent.challenge.service.PedidosService;

/**
 * @author Leito
 *
 */
@Service
public class PedidoServiceImpl implements PedidosService {

	private static final Logger logger = LoggerFactory.getLogger(PedidoServiceImpl.class);

	private BumexMemcachedDummy memChache;

	public PedidoServiceImpl(BumexMemcachedDummy memChache) {
		this.memChache = memChache;
	}

	@Override
	public void upsert(Pedido pedido) {

		if (pedido.getId() != null) {

			logger.info(String.format("getting pedido id %s from cache", pedido.getId()));

			Pedido pedidoMemCached = get(pedido.getId());
			pedidoMemCached.setDescuento(pedido.getDescuento());
			pedidoMemCached.setMonto(pedido.getMonto());
			pedidoMemCached.setNombre(pedido.getNombre());

			memChache.set(pedidoMemCached.getId(), pedidoMemCached);

			logger.info(String.format("Pedido id %s updated in cache", pedido.getId()));

		} else {

			PedidoDAO.insertOrUpdate(pedido);
			logger.info(String.format("saved pedido id %s in DB", pedido.getId()));
			memChache.set(pedido.getId(), pedido);
			logger.info(String.format("saved pedido id %s in Cache", pedido.getId()));

		}

	}

	@Override
	public Pedido get(long id) {
		logger.info(String.format("getting pedido id %s from cache", id));
		return (Pedido) memChache.get(id);
	}

	@Override
	public void delete(long id) {

		PedidoDAO.delete(id);
		logger.info(String.format("deleted pedido id %s in DB", id));
		memChache.delete(id);
		logger.info(String.format("deleted pedido id %s in cache", id));

	}

}
