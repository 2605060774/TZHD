package com.taizhou.taizhou_back.mapper;

import com.taizhou.taizhou_back.pojo.PbItemInfo;

import java.util.List;

public interface MoneyMapper {
    List<PbItemInfo> principalCheck();

    int backMoney(Integer id);

    List<PbItemInfo> normalMoney();

    List<PbItemInfo> anormalMoney();

    List<PbItemInfo> financeCheck();

    int financeBack(Integer applyId);

    List<PbItemInfo> alreadyBack();

    List<PbItemInfo> itemShow();

    List<PbItemInfo> payMoney();
}
