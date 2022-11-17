package com.founder.fasf.map;

import com.founder.fasf.beans.ClassMetadata;
import org.springframework.core.Conventions;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Andy
 * Date: 13-1-24
 * Time: 下午4:27
 * To change this template use File | Settings | File Templates.
 */
public class ResultModelMap extends LinkedHashMap<String,Object> implements Serializable {
    /**
     * create new map
     */
    public ResultModelMap(){
    }

    /**
     *
     * @param resultKey
     * @param resultObject
     */
    public ResultModelMap(String resultKey, Object resultObject) {
             addAttribute(resultKey, resultObject);
    }

    /**
     *
     * @param resultKey
     * @param resultObject
     * @return
     */
    public ResultModelMap addAttribute(String resultKey, Object resultObject) {
        Assert.notNull(resultKey, "Model attribute name must not be null");
        put(resultKey, resultKey);
        return this;
    }

    /**
     *
     * @param attributeValue
     */
    public ResultModelMap(Object attributeValue) {
        addAttribute(attributeValue);
    }

    /**
     * key为对象类名
     * @param attributeValue
     * @return
     */
    public ResultModelMap addAttribute(Object attributeValue) {
        Assert.notNull(attributeValue, "Model object must not be null");
        if (attributeValue instanceof Collection && ((Collection) attributeValue).isEmpty()) {
            return this;
        }
        return addAttribute(Conventions.getVariableName(attributeValue), attributeValue);
    }

    /**
     *
     * @param attributeValues
     * @return
     */
    public ResultModelMap addAllAttributes(Collection<?> attributeValues) {
        if (attributeValues != null) {
            for (Object attributeValue : attributeValues) {
                addAttribute(attributeValue);
            }
        }
        return this;
    }

    /**
     *
     * @param attributes
     * @return
     */
    public ResultModelMap addAllAttributes(Map<String, ?> attributes) {
        if (attributes != null) {
            putAll(attributes);
        }
        return this;
    }

    /**
     *
     * @param attributes
     * @return
     */
    public ResultModelMap mergeAttributes(Map<String, ?> attributes) {
        if (attributes != null) {
            for (String key : attributes.keySet()) {
                if (!containsKey(key)) {
                    put(key, attributes.get(key));
                }
            }
        }
        return this;
    }

    /**
     *
     * @param attributeName
     * @return
     */
    public boolean containsAttribute(String attributeName) {
        return containsKey(attributeName);
    }

    /**
     *
     * @param entity
     * @return
     */
    public ResultModelMap addEntity(Object entity) {
        Assert.isNull(entity,"Entity must not be null!");
        String entityName = Conventions.getVariableName(entity);
        ClassMetadata classMetadata = ClassMetadata.getMetadata(entity.getClass());
            return this;
    }
}

