package com.jc.modules.company.service.impl;

import com.jc.modules.company.entity.Company;
import com.jc.modules.company.mapper.CompanyMapper;
import com.jc.modules.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: Charles Chan
 * @Date: 2019/3/11 17:04
 * @Version 1.0
 * 公司业务类
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    //公司代号
    private static final Integer COM_CODE = 1;

    @Resource
    private CompanyMapper companyMapper;

    @Override
    public Company getCompanyMessage() {
        return companyMapper.selectById(COM_CODE);
    }
}
