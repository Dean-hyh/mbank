package com.ms.credit.pojo.VO;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/11/29 16:47
 */
public class LuckyEmpVO implements Serializable {

    //活动标题
    private String eventTitle;

    //序号
    private String SeriaNo;

    //等级
    private String grade;

    //中奖人
    private String empName;

    //中奖日期
    private Date awardDate;

    //奖品内容
    private String prize;

    public LuckyEmpVO() {
    }

    public LuckyEmpVO(String eventTitle, String seriaNo, String grade, String empName, Date awardDate, String prize) {
        this.eventTitle = eventTitle;
        SeriaNo = seriaNo;
        this.grade = grade;
        this.empName = empName;
        this.awardDate = awardDate;
        this.prize = prize;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getSeriaNo() {
        return SeriaNo;
    }

    public void setSeriaNo(String seriaNo) {
        SeriaNo = seriaNo;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Date getAwardDate() {
        return awardDate;
    }

    public void setAwardDate(Date awardDate) {
        this.awardDate = awardDate;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }
}
