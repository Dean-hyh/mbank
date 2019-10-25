package com.ms.framework;

import java.awt.event.HierarchyBoundsListener;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/9/29 16:57
 */
public interface ConfigurableContext extends HierarchicalContext{
    void remove(String key);

    void setContextFilter(ContextFilter filter);

    ContextStore getStore();
}
