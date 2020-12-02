package com.taizhou.taizhou_back.mapper;

import com.taizhou.taizhou_back.pojo.PbItemApplyInfo;
import org.apache.ibatis.annotations.Param;

public interface BusinessMapper {
    int addApplyInfo(PbItemApplyInfo pbItemApplyInfo);

    PbItemApplyInfo showApplyInfo(Integer id);

    PbItemApplyInfo showApplyInfoByStatus();

    int updateApplyStatus(@Param("itemName") String itemName,@Param("id")  Integer id,@Param("status") Integer status);
}

