package com.ms.credit.pojo.DO;

import java.io.Serializable;

public class SeqConf implements Serializable {
    private String seqId;

    private Short seqCurrent;

    private Short seqMaximum;

    private static final long serialVersionUID = 1L;

    public String getSeqId() {
        return seqId;
    }

    public void setSeqId(String seqId) {
        this.seqId = seqId == null ? null : seqId.trim();
    }

    public Short getSeqCurrent() {
        return seqCurrent;
    }

    public void setSeqCurrent(Short seqCurrent) {
        this.seqCurrent = seqCurrent;
    }

    public Short getSeqMaximum() {
        return seqMaximum;
    }

    public void setSeqMaximum(Short seqMaximum) {
        this.seqMaximum = seqMaximum;
    }
}