package com.ms.credit.pojo.DO;

import java.io.Serializable;

public class PermMenuKey implements Serializable {
    private String permId;

    private String menuId;

    private static final long serialVersionUID = 1L;

    public String getPermId() {
        return permId;
    }

    public void setPermId(String permId) {
        this.permId = permId == null ? null : permId.trim();
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }
}