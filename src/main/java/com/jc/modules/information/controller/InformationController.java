package com.jc.modules.information.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.jc.common.utils.ResponseUtil;
import com.jc.modules.information.entity.InformationEntity;
import com.jc.modules.information.service.InformationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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


}
