package com.jc.modules.information.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.jc.common.utils.ResponseUtil;
import com.jc.modules.information.entity.InformationEntity;
import com.jc.modules.information.service.InformationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/3/12 17:53
 * @description：资讯信息controller
 * @modified By：
 * @version:
 */
@RestController
@RequestMapping("/information")
@Api(description = "资讯核心表")
public class InformationController {

    @Autowired
    private InformationService informationService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ApiOperation(value = "资讯核心列表查询", notes = "列表查询")
    public ResponseUtil findInformationList(int pageNo,int pageSize){
        Page<InformationEntity> page = new Page<>(pageNo, pageSize);
        EntityWrapper<InformationEntity> entityEntityWrapper = new EntityWrapper<>();
        List<InformationEntity> pageList = informationService.findByPage(page, entityEntityWrapper);
        return ResponseUtil.success(pageList);
    }


    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    @ApiOperation(value = "获取单个资讯核心类型",notes = "资讯查询")
    public ResponseUtil selectById(@PathVariable Integer id){
        InformationEntity informationEntity = informationService.selectById(id);
        return ResponseUtil.success(informationEntity);
    }
    
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ApiOperation(value = "新增资讯核心类型",notes = "新增")
    public ResponseUtil insertInfo(InformationEntity informationEntity){
        informationService.insertInfo(informationEntity);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/batch/insert",method = RequestMethod.POST)
    @ApiOperation(value = "批量新增资讯核心类型",notes = "批量新增")
    public ResponseUtil batchInsertInfo(List<InformationEntity> infoList){
        informationService.batchInsertInfo(infoList);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    @ApiOperation(value = "更新资讯核心类型",notes = "更新")
    public ResponseUtil updateInfoById(InformationEntity informationEntity){
        informationService.updateInfoById(informationEntity);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    @ApiOperation(value = "删除资讯核心类型",notes = "删除")
    public ResponseUtil deleteInfoById(@PathVariable Integer id){
        informationService.deleteInfoById(id);
        return ResponseUtil.success();
    }

}
