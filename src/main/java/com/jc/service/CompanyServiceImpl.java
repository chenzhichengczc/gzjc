package com.jc.service;

import com.jc.mapper.CompanyMapper;
import com.jc.po.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: Charles Chan
 * @Date: 2019/3/7 1:01
 * @Version 1.0
 */
@Service
public class CompanyServiceImpl implements CompanyService{

    @Resource
    private CompanyMapper companyMapper;

    /**
     * 获取公司信息
     * @return 公司实体类对象
     */
    @Override
    public Company getCompanyMessage() {
        return companyMapper.getCompanyMessage();
    }
}
