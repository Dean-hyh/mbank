package com.ms.framework;

import java.util.Map;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/9/29 17:01
 */
public interface HierarchicalContext extends ListableContext {
    Context getParentContext();

    boolean constainsLocalKey(String key);

    <T> Map<String,T> getLocal(Class<T> valueType);

    Object getLocal(String key);

    <T> T getLocal(String key,Class<T> valueType);

}
