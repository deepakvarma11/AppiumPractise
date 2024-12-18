package com.appium.utils;

import org.assertj.core.api.Assertions;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class TestCache {

    private static final ThreadLocal<TestCacheMap> CACHE = new ThreadLocal<>();

    public static void initialize(){
        CACHE.set(new TestCacheMap());
    }

    public static void remove(){
        CACHE.remove();
    }

    public static TestCacheMap getCache(){
        return CACHE.get();
    }

    public static String getStringValue(final String key){
        return String.valueOf(getCache().get(key));
    }

    public static Object getValue(final String key, Class<?> type){
        Object object = getCache().get(key);
        if (!Objects.isNull(object)) {
            Assertions.assertThat(object).as("Incompatible type of object returned from TestCache")
                    .isInstanceOf(type);
        }
        return getCache().get(key);
    }

    public static void putValue(final String key, final Object value){
        getCache().put(key, value);
    }

    private static class TestCacheMap extends ConcurrentHashMap<Object, Object>{

        @Override
        public Object put(Object key, Object value){
            return Objects.isNull(value) ? super.remove(key) : super.put(key, value);
        }
    }
}
