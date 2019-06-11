package com.navent.challenge.cache;

/**
 * 
 * @author Leito
 *
 */
public interface BumexMemCache {

	public Object get(long key);

	public void set(long key, Object value);

	public void delete(long key);

}
