package com.taizhou.taizhou_back.pojo;


import lombok.Data;

import java.util.Date;
@Data
public class PbApplyDetailInfo {

  private String seqId;
  private String applyId;
  private String objectId;
  private double money;
  private Date depositTime;
  private String depositFrom;
  private Integer depositBack;
  private Integer depositPayStatus;//缴费状态
  private String isBidder;
  private String isReturn;
  private Date backTime;//退费时间
  private String createUserId;
  private String updateUserId;
  private Date createTime;
  private Date updateTime;



}
