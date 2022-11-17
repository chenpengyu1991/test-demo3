package com.founder.fasf.cache;

import java.io.Serializable;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

public class EhCacheImpl<T extends Serializable> implements ICache<T> {
	private Cache cache;

	@SuppressWarnings("unchecked")
	@Override
	public T getCache(String key) {
		Element element = cache.get(key);
		if (element != null) {
			return (T) element.getValue();
		}
		return null;
	}

	@Override
	public void setCache(String key, T t) {
		if (key != null && !key.equals("")) {
			cache.put(new Element(key, t));
		}
	}

	@Override
	public boolean containsKey(String key) {
		return cache.isKeyInCache(key);
	}

	@Override
	public void remove(String... keys) {
		if (keys.length > 0) {
			for (String key : keys) {
				if (cache.isKeyInCache(key)) {
					cache.remove(key);
				}
			}
		}
	}

	@Override
	public void cleanAll() {
		// cache.removeAll();
		cache.getCacheManager().clearAll();
	}
}
