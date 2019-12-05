package com.dy.h5jingbiao.service;

import com.dy.h5jingbiao.entity.Organize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrganizeService {

    /*获取参与支行的列表*/
    List<Organize> selectOrganizeList();
}
