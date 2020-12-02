package com.taizhou.taizhou_back.service;

import com.taizhou.taizhou_back.pojo.PbItemApplyInfo;
import com.taizhou.taizhou_back.utils.BaseResponse;

public interface BusinessService {
    BaseResponse addApplyInfo(PbItemApplyInfo pbItemApplyInfo);

    BaseResponse showApplyInfo(String token);

    BaseResponse showApplyInfoByStatus();

    BaseResponse updateApplyStatus(String token, String itemName,Integer status);
}
