package com.taizhou.taizhou_back.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class PbRule {

  private Integer pbRuleId;
  private String pbPattern;
  private Integer pbPriority;
  private String pbPreferredBidder;
  private double pbPrice;
  private String pbReservePrice;
  private String pbStartingPrice;
  private Integer pbBiddingWay;
  private Integer pbDuration;
  private String pbRange;
  private String pbServiceCharge;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date startTime;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date endTime;




  private String objectName;





}
