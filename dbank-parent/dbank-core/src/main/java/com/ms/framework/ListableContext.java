package com.ms.framework;

import java.util.Map;
import java.util.Set;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/9/29 17:04
 */
public interface ListableContext extends Context {
    <T> Map<String,T> get(Class<T> valueType);

    Set<String> getKeys();
}
