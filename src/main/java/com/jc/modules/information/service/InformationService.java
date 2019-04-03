package com.jc.modules.information.service;


import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.jc.modules.information.entity.InformationEntity;

import java.util.List;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/3/12 18:10
 * @description：资讯核心service
 * @modified By：
 * @version:
 */
public interface InformationService extends IService<InformationEntity> {

    /**
     * 分页查询
     *
     * @param ：page,queryWrapper
     * @return :
     * @author ：fenghuang
     * @date ：Created in 2019/3/13 14:36
     */
    List<InformationEntity> findByPage(Page<InformationEntity> page, Wrapper<InformationEntity> wrapper);

    InformationEntity selectById(Integer id);

    void insertInfo(InformationEntity informationEntity);

    void batchInsertInfo(List<InformationEntity> infoList);

    void updateInfoById(InformationEntity informationEntity);

    void deleteInfoById(Integer id);

    List<InformationEntity> selectPage();

}
