package com.taizhou.taizhou_back.pojo;


import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel("用户")
public class User {

  private Integer id;
  private String userName;
  private String password;
  private String idCard;
  private String mobile;
  private String card;
  private String cardName;
  private String realName;
  private String businessName;
  private String businessAddress;
  private String corName;
  private String corNum;

  private String roleName;

}
