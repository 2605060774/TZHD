package com.taizhou.taizhou_back.pojo;


import lombok.Data;

import java.util.Date;
@Data
public class PbApplyInfo {

  private String seqId;
  private String itemId;
  private String enterId;
  private String bidName;//竞买人名称
  private Integer bidType;
  private String enterOrgCode;
  private String idcard;
  private String moble;
  private String mark;
  private String objectId;
  private double money;
  private String objectsFlag;
  private String createUserId;
  private String updateUserId;
  private Date createTime;
  private Date updateTime;
  private String isDel;


}
