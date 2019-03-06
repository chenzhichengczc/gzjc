package com.jc.controller.company;

import com.jc.json.JsonResult;
import com.jc.po.Company;
import com.jc.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Charles Chan
 * @Date: 2019/3/7 0:58
 * @Version 1.0
 */
@RestController("/company")
public class CompanyContoller {

    @Autowired
    private CompanyService companyService;

    /**
     * 获取公司对象信息
     * @return Json数据绑定
     */
    @RequestMapping("/getCompanyMessage")
    public JsonResult getCompanyMessage(){
        Company company = companyService.getCompanyMessage();
        return null;
    }

}
