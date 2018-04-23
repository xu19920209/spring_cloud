package com.tuyue.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Yanghu123
 * @since 2018-03-07
 */
@TableName("trading_area")
public class TradingArea extends Model<TradingArea> {

    private static final long serialVersionUID = 1L;

    /**
     * 商圈id
     */
    @TableId(value = "com_busines_id", type = IdType.AUTO)
    private Integer comBusinesId;
    /**
     * 商圈名
     */
    @TableField("business_circles")
    private String businessCircles;
    /**
     * 创建时间
     */
    @TableField("creat_time")
    private Date creatTime;
    /**
     * 来源
     */
    private Integer source;


    public Integer getComBusinesId() {
        return comBusinesId;
    }

    public void setComBusinesId(Integer comBusinesId) {
        this.comBusinesId = comBusinesId;
    }

    public String getBusinessCircles() {
        return businessCircles;
    }

    public void setBusinessCircles(String businessCircles) {
        this.businessCircles = businessCircles;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    @Override
    protected Serializable pkVal() {
        return this.comBusinesId;
    }

    @Override
    public String toString() {
        return "TradingArea{" +
        ", comBusinesId=" + comBusinesId +
        ", businessCircles=" + businessCircles +
        ", creatTime=" + creatTime +
        ", source=" + source +
        "}";
    }
}
