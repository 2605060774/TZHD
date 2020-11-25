package com.taizhou.taizhou_back.pojo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("权限")
public class Permission {

  private Integer perId;
  private String pName;
  private Integer pId;
  private String path;


  private List<Permission> perList;


}
