package com.ms.credit.pojo;

import java.io.Serializable;

public class Demo implements Serializable {
    private String demoId;

    private String demoName;

    private String demoMobile;

    private String demoEmail;

    private static final long serialVersionUID = 1L;

    public String getDemoId() {
        return demoId;
    }

    public void setDemoId(String demoId) {
        this.demoId = demoId == null ? null : demoId.trim();
    }

    public String getDemoName() {
        return demoName;
    }

    public void setDemoName(String demoName) {
        this.demoName = demoName == null ? null : demoName.trim();
    }

    public String getDemoMobile() {
        return demoMobile;
    }

    public void setDemoMobile(String demoMobile) {
        this.demoMobile = demoMobile == null ? null : demoMobile.trim();
    }

    public String getDemoEmail() {
        return demoEmail;
    }

    public void setDemoEmail(String demoEmail) {
        this.demoEmail = demoEmail == null ? null : demoEmail.trim();
    }
}