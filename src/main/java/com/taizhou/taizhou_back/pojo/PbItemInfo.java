package com.taizhou.taizhou_back.pojo;


import lombok.Data;

import java.util.Date;
@Data
public class PbItemInfo {

  private String seqId;
  private String applyId;
  private String itemName;
  private String itemCode;
  private String itemType;
  private String itemArea;
  private Integer itemAreaId;
  private String tradWay;
  private Integer resourceType;//台州：资源类型1拓展资源，2国有产权  富阳：交易类型1土地经营权，2林地使用权，3集体房屋使用权，4集体资产售卖，5其他
  private String transferor;
  private Integer depositPayWay;
  private Date depositTime;//保证金缴纳截止时间
  private Integer qualExamWay;
  private String transferorMan;
  private String transferorAddr;
  private String transferorPhone;
  private Date applyStartTime;//报名开始时间
  private Date applyEndTime;
  private String agentName;
  private String agentId;
  private Integer supplyTypeId;
  private String depositCharge;
  private String accountName;
  private String bankName;
  private String bankCode;
  private String linkMan;
  private String linkPhone;
  private String objectSituation;
  private String bidderQual;
  private String isShow;
  private Integer bidWay;
  private Integer bidState;
  private Integer dealWay;
  private Integer applyWay;
  private String paymentWay;
  private String applyNotice;
  private String otherDeal;
  private Integer phase;
  private Integer freeBidLen;
  private Integer delayBidLen;
  private Integer maxMultiple;
  private String tradAgencyMan;
  private String tradAgencyAddr;
  private String tradAgencyPhone;
  private double flowId;
  private double runId;
  private String createUserId;
  private String updateUserId;
  private Date createTime;
  private Date updateTime;
  private String isDel;

  private String bidName;//竞买人名称
  private Date bidStartTime;//竞价开始时间
  private String objectName;
  private Date backTime;//退费时间
  private double money;
  private Integer depositPayStatus;//缴费状态
  private String isReturn;


}
