package com.dy.h5jingbiao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dy.h5jingbiao.entity.Organize;
import com.dy.h5jingbiao.mapper.OrganizeMapper;
import com.dy.h5jingbiao.service.OrganizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizeServiceImpl implements OrganizeService {

    @Autowired
    private OrganizeMapper organizeMapper;

    @Override
    public List<Organize> selectOrganizeList() {
        return organizeMapper.selectList(new QueryWrapper<>());
    }
}
