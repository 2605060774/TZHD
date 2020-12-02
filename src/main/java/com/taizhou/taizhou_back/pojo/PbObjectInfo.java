package com.taizhou.taizhou_back.pojo;


import lombok.Data;

import java.util.Date;
@Data
public class PbObjectInfo {

  private String seqId;
  private String itemId;
  private Integer orderNum;
  private String objectCode;
  private String objectName;
  private String objectAddress;
  private Integer trad;
  private Integer priorityWay;
  private Integer priorityCount;
  private Date bidDelayTime;
  private Date bidStartTime;//竞价开始时间
  private Integer priorityBidType;
  private String priorityApplyId;
  private String priorityEnterName;
  private Integer priorityConfirmLen;
  private Integer bidderType;
  private String unit;
  private double quoteIncrement;
  private Integer splitDecimal;
  private double evaluatePrice;
  private double startPrice;
  private String isReservePrice;
  private double reservePrice;
  private double cmcostAmount;
  private Integer chargeState;
  private double scale;
  private double charge;
  private double closePrice;
  private Integer bidStatus;
  private String isPause;
  private Date pauseTime;
  private Date depositPayEndTime;
  private Integer delayTimes;
  private double sellAcreage;
  private String acreageUnit;
  private double leaseTerm;
  private double applyNum;
  private String remark;
  private double flowId;
  private double runId;
  private String createUserId;
  private String updateUserId;
  private Date createTime;
  private Date updateTime;
  private String isDel;


}
