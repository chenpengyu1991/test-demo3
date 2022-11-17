package com.founder.rhip.mdm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Criterion;
import com.founder.fasf.beans.Record;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ArrayUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.mdm.entity.EntityType;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MDMService extends AbstractService {
	
	@Resource
	private Cache ehCache;
	
	protected static final String MAP_KEY = "map_";

	protected static final String LSIT_KEY = "list_";
	
	protected Object getCache(EntityType et,String key) {
		if(!isNull(et)){
			key=et.toString()+"_"+key;
		}
		Element element = ehCache.get(key);
		if (element != null) {
			return element.getValue();
		}
		return null;
	}
	
	protected void setCache(EntityType et,String key, Object t) {
		if (!isNull(key)) {
			if(!isNull(et)){
				key=et.toString()+"_"+key;
			}
			ehCache.put(new Element(key, t));
		}
	}
	
	protected void removeCache(EntityType et,String key) {
		if (!isNull(ehCache)) {
			//key=et.toString()+"_"+key;
			//ehCache.remove(key);
			List removeKeys = new ArrayList();
			List keys = ehCache.getKeys();
			String etStr = et.toString();
			for (Object obj : keys) {
				String keyStr = obj.toString();
				if (keyStr.startsWith(etStr)) {
					if (keyStr.contains(key)) {
						removeKeys.add(obj);
					}
				}
			}
			ehCache.removeAll(removeKeys);
		}
	}
	
	protected void removeCache(EntityType et) {
		if (!isNull(ehCache)) {
			List removeKeys = new ArrayList();
			List keys = ehCache.getKeys();
			String etStr = et.toString();
			for (Object key : keys) {
				if (key.toString().startsWith(etStr)) {
					removeKeys.add(key);
				}
			}
			ehCache.removeAll(removeKeys);
		}
	}
	
	protected void cleanAllCache() {
		ehCache.removeAll();
	}
	
	protected String criteriaToKey(Criteria criteria) {
		if (criteria == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		List<Criterion> cris = criteria.getCriteria();
		for (Criterion cri : cris) {
			String str = cri.toString();
			sb.append(str.subSequence(str.indexOf("["), str.indexOf("]") + 1));
			sb.append("&&");
		}
		return sb.toString();
	}
	
	protected List<List> getInsertLogs(List codes) {
		List<List> ret = new ArrayList<List>();
		List ids = new ArrayList();
		for (int index = 0; index <  codes.size(); index++) {
			Object code = codes.get(index);
			ids.add(code);
			if (ids.size() % 1000 == 0) {
				ret.add(ids);
				ids = new ArrayList();
			}
		}
		if (ids.size() > 0) {
			ret.add(ids);
		}
		return ret;
	}
	
	public static Record getChangedValue(Record left,Record right,String... properties){
		Record rtMap= new Record();
		Collection<String> keys;
		if(ObjectUtil.isNotEmpty(properties)){
			keys=ArrayUtil.toList(properties);
		}else{
			keys=left.getPropertyNames();
		}
		for(String name:keys){
			int flag=(isNull(name,left.get(name))?0:10)+(isNull(name,right.get(name))?0:1);
			if(flag== 1){
				rtMap.put(name, right.get(name));
				continue;
			}
			if(flag==11){
				if(!right.get(name).toString().equals(left.get(name).toString())){
					rtMap.put(name, right.get(name));
				}
			}
		}
		return rtMap;
	}
	
	public static Boolean isNull(String property,Object value){
		if(ObjectUtil.isNullOrEmpty(value)){
			return true;
		}
		return false;
	}
	
	public static Boolean isNull(Object value) {
		if(ObjectUtil.isNullOrEmpty(value)){
			return true;
		} else if (value instanceof Collection) {
			Collection c = (Collection)value;
			return c.size() == 0;
		}
		return false;
	}
	
	public static Boolean isNotNull(Object value) {
		return !isNull(value);
	}
	
}
