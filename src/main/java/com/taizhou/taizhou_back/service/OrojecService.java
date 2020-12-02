package com.taizhou.taizhou_back.service;

import com.taizhou.taizhou_back.pojo.PbItemInfo;
import com.taizhou.taizhou_back.pojo.PbRule;
import com.taizhou.taizhou_back.pojo.Permission;

import java.util.List;

public interface OrojecService {

    List<PbItemInfo> orojecShow(PbItemInfo pbItemInfo);

    int biddingRules(PbRule pbRule) throws Exception;

    List<PbItemInfo> orojecshenhe(PbItemInfo pbItemInfo);

    int rojecbyId(PbItemInfo pbItemInfo);
}
