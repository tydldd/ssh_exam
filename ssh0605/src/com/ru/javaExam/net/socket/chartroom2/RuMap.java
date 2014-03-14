package com.ru.javaExam.net.socket.chartroom2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：nange
 * 创建时间：2014年3月14日 上午10:03:52
 * 修改人：nange
 * 修改时间：2014年3月14日 上午10:03:52
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
public class RuMap<K, V> extends HashMap<K, V>{
	
	/**
	 * 通过value得到key
	 * @param value
	 * @return K
	 */
	public K getKeyByValue(V value){
		for(K key : keySet()){
			if(get(key) == value || get(key).equals(value)){
				return key;
			}
		}
		return null;
	}
	
	public Set<V> valueSet(){
		HashSet<V> set = new HashSet<V>();
		for(K key : keySet()){
			V value = get(key);
			set.add(value);
		}
		return set;
	}
	
	/**
	 * 重写hashmap的put方法，键和值都不能重复
	 */
	@Override
	public V put(K key, V value) {
		for(V val : valueSet()){
			if(val.equals(value) && val.hashCode() == value.hashCode()){
				throw new RuntimeException("值不能重复");
			}
		}
		return super.put(key, value);
	}
}
