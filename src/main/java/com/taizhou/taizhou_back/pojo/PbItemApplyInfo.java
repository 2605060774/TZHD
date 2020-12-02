package com.taizhou.taizhou_back.pojo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("项目申请")
public class PbItemApplyInfo {

  private String seqId;
  private String itemName; //项目名称
  private String resourceType;
  private String itemDepName;//主管部门
  private String delegateName; //委托方名称
  private String delegateMan; //委托方联系人
  private String delegatePhone; //委托人电话
  private String applyPersonId;
  private String itemLeaderId;
  private String itemSummary; //项目简要概述
  private double flowId;
  private double runId;
  private String createUserId;
  private String updateUserId;
  private Date createTime;
  private Date updateTime;
  private String isDel;
  private String token;
  private Integer status;
}
