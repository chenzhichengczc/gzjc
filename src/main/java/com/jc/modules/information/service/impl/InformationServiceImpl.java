package com.jc.modules.information.service.impl;


import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jc.modules.information.entity.InformationEntity;
import com.jc.modules.information.mapper.InformationMapper;
import com.jc.modules.information.service.InformationService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/3/12 18:11
 * @description：资讯核心serviceImpl
 * @modified By：
 * @version:
 */
@Service
public class InformationServiceImpl extends ServiceImpl<InformationMapper, InformationEntity> implements InformationService {

    @Resource
    private InformationMapper informationMapper;

    @Override
    public List<InformationEntity> findByPage(Page<InformationEntity> page, Wrapper<InformationEntity> wrapper) {

        List<InformationEntity> informationList = informationMapper.selectPage(page, wrapper);
        return informationList;
    }


}
