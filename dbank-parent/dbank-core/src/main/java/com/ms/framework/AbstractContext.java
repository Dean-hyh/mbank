package com.ms.framework;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/9/29 16:06
 */
public abstract class AbstractContext implements ConfigurableContext {
    private final Context parentContext;
    private final ContextStore store;
    private ContextFilter filter;

    public AbstractContext() {
        this(null,new UnmodifiableStore());
    }

    public AbstractContext(Context parentContext) {
        this(null,new UnmodifiableStore());
    }

    public AbstractContext(ContextStore store) {
        this(null,new UnmodifiableStore());
    }

    public AbstractContext(Context parentContext, ContextStore store) {
        this.parentContext = parentContext;
        this.store = store;
    }

    @Override
    public ContextStore getStore(){
        return store;
    }

    @Override
    public Context getParentContext(){
        return parentContext;
    }

    @Override
    public boolean constainsLocalKey(String key) {
        return getStore().containsKey(key);
    }

    @Override
    public Object get(String key) {
        Object value = getStore().get(key);
        if(value == null && getParentContext()!=null){
            value=getParentContext().get(key);
        }
        return value;
    }

    @Override
    public <T> T get(String key, Class<T> valueType) {
        Object value = get(key);
        if(value == null){
            return null;
        }
        return valueType.cast(value);
    }

    @Override
    public <T> Map<String, T> get(Class<T> valueType) {
        Map<String, T> res = new HashMap<>();
        if(getParentContext() != null && (getParentContext() instanceof ListableContext)){
            res.putAll(((ListableContext) getParentContext()).get(valueType));
        }
        res.putAll(getLocal(valueType));
        return res;
    }

    @Override
    public Object getLocal(String key) {
        return getStore().get(key);
    }

    @Override
    public <T> T getLocal(String key, Class<T> valueType) {
        Object value = getLocal(key);
        if(value==null){
            return null;
        }
        return valueType.cast(value);
    }

    @Override
    public boolean containsKey(String key) {
        if(constainsLocalKey(key)){
            return true;
        }else if (getParentContext() != null){
            return getParentContext().containsKey(key);
        }else{
            return false;
        }
    }

    @Override
    public void put(String key, Object value) {
        if(filter!=null){
            if(filter.filterPut(key,value,this)){
                getStore().put(key,value);
            }
        }else {
            getStore().put(key,value);
        }
    }

    @Override
    public void putAll(Map<String, Object> dataMap) {
        if(filter!=null){
            if(filter.filterPutAll(dataMap,this)){
                getStore().putAll(dataMap);
            }
        }else {
            getStore().putAll(dataMap);
        }
    }

    @Override
    public void remove(String key) {
        if(filter!=null){
            if(filter.filterRemove(key,this)){
                getStore().remove(key);
            }
        }else {
            getStore().remove(key);
        }
    }

    @Override
    public void setContextFilter(ContextFilter filter) {
        this.filter=filter;
    }

    private static class UnmodifiableStore implements ContextStore{

        @Override
        public Object get(String key) {
            return null;
        }

        @Override
        public boolean containsKey(String key) {
            return false;
        }

        @Override
        public void put(String key, Object value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void putAll(Map<String, Object> dataMap) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove(String key) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Map<String, Object> toMap() {
            return null;
        }

        @Override
        public Object getNativeStore() {
            return null;
        }
    }
}
