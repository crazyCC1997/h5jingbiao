package com.dy.h5jingbiao.service.impl;

import com.dy.h5jingbiao.entity.RelActivityAndOrganize;
import com.dy.h5jingbiao.mapper.RelActivityAndOrganizeMapper;
import com.dy.h5jingbiao.service.RelActivityAndOrganizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RelActivityAndOrganizeServiceImpl implements RelActivityAndOrganizeService {

    @Autowired
    private RelActivityAndOrganizeMapper relActivityAndOrganizeMapper;

    @Override
    public int insertOrganizeDetail(RelActivityAndOrganize relActivityAndOrganize) {
        return relActivityAndOrganizeMapper.insert(relActivityAndOrganize);
    }

    @Override
    public int deleteByMap(Map<String, Object> organizeDetailMap) {
        return relActivityAndOrganizeMapper.deleteByMap(organizeDetailMap);
    }
}
