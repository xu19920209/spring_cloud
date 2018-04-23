package com.tuyue.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Yanghu123
 * @since 2018-03-09
 */
public class Report extends Model<Report> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("report_id")
    private Integer reportId;
    /**
     * 举报内容
     */
    @TableField("report_content")
    private String reportContent;
    /**
     * 举报时间
     */
    @TableField("report_time")
    private String reportTime;
    /**
     * 用户id
     */
    private Integer aid;
    /**
     * 留言id
     */
    @TableField("word_id")
    private Integer wordId;


    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getWordId() {
        return wordId;
    }

    public void setWordId(Integer wordId) {
        this.wordId = wordId;
    }

    @Override
    protected Serializable pkVal() {
        return this.reportId;
    }

    @Override
    public String toString() {
        return "Report{" +
        ", reportId=" + reportId +
        ", reportContent=" + reportContent +
        ", reportTime=" + reportTime +
        ", aid=" + aid +
        ", wordId=" + wordId +
        "}";
    }
}
