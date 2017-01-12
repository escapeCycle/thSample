package com.xunhuan.entity.mybatis.overdue;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by escapeCycle on 2016/12/15.
 */
public class OverdueEEndPayDetail {

    private Long id;
    private Long bidId;
    private BigDecimal amount;
    private BigDecimal bidSurplusAmount;
    private Date payTime;
    private String reason;
    private Date createTime;
    private Date updateTime;
    private Long overdueOperator;
    private String remark;

    public OverdueEEndPayDetail() {

    }

    public OverdueEEndPayDetail(Long id, Long bidId, BigDecimal amount, BigDecimal bidSurplusAmount, Date payTime, String reason, Date createTime, Date updateTime, Long overdueOperator, String remark) {
        super();
        this.id = id;
        this.bidId = bidId;
        this.amount = amount;
        this.bidSurplusAmount = bidSurplusAmount;
        this.payTime = payTime;
        this.reason = reason;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.overdueOperator = overdueOperator;
        this.remark = remark;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBidId() {
        return bidId;
    }

    public void setBidId(Long bidId) {
        this.bidId = bidId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getBidSurplusAmount() {
        return bidSurplusAmount;
    }

    public void setBidSurplusAmount(BigDecimal bidSurplusAmount) {
        this.bidSurplusAmount = bidSurplusAmount;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getOverdueOperator() {
        return overdueOperator;
    }

    public void setOverdueOperator(Long overdueOperator) {
        this.overdueOperator = overdueOperator;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
