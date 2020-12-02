package com.taizhou.taizhou_back.service.impl;

import com.taizhou.taizhou_back.mapper.OrojecMapper;
import com.taizhou.taizhou_back.pojo.PbItemInfo;
import com.taizhou.taizhou_back.pojo.PbRule;
import com.taizhou.taizhou_back.service.OrojecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class OrojecServiceImpl implements OrojecService {
    @Autowired
    private OrojecMapper orojecMapper;

    @Override
    public List<PbItemInfo> orojecShow(PbItemInfo pbItemInfo) {
        return orojecMapper.orojecShow(pbItemInfo);
    }

    @Override
    public int biddingRules(PbRule pbRule) throws Exception {
        int i = orojecMapper.biddingRules(pbRule);
        int j = orojecMapper.biddingRules1(pbRule);
        if (i==0||j==0){
            throw new Exception();
        }
        return i+j;
    }

    @Override
    public List<PbItemInfo> orojecshenhe(PbItemInfo pbItemInfo) {
        return orojecMapper.orojecshenhe(pbItemInfo);
    }

    @Override
    public int rojecbyId(PbItemInfo pbItemInfo) {
        return orojecMapper.rojecbyId(pbItemInfo);
    }
}
