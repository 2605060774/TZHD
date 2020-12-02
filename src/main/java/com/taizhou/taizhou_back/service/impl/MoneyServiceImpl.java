package com.taizhou.taizhou_back.service.impl;

import com.taizhou.taizhou_back.mapper.MoneyMapper;
import com.taizhou.taizhou_back.pojo.PbItemInfo;
import com.taizhou.taizhou_back.service.MoneyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MoneyServiceImpl implements MoneyService {
    @Resource
    private MoneyMapper moneyMapper;
    @Override
    public List<PbItemInfo> principalCheck() {
        return moneyMapper.principalCheck();
    }

    @Override
    public int backMoney(Integer id) {
        return moneyMapper.backMoney(id);
    }

    @Override
    public List<PbItemInfo> normalMoney() {
        return moneyMapper.normalMoney();
    }

    @Override
    public List<PbItemInfo> anormalMoney() {
        return moneyMapper.anormalMoney();
    }

    @Override
    public List<PbItemInfo> financeCheck() {
        return moneyMapper.financeCheck();
    }

    @Override
    public int financeBack(Integer applyId) {
        return moneyMapper.financeBack(applyId);
    }

    @Override
    public List<PbItemInfo> alreadyBack() {
        return moneyMapper.alreadyBack();
    }

    @Override
    public List<PbItemInfo> itemShow() {
        return moneyMapper.itemShow();
    }

    @Override
    public List<PbItemInfo> payMoney() {
        return moneyMapper.payMoney();
    }
}
