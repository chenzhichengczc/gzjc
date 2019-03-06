package com.jc.mapper;

import com.jc.po.Company;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: Charles Chan
 * @Date: 2019/3/7 1:04
 * @Version 1.0
 */
public interface CompanyMapper {

    @Select("")
    Company getCompanyMessage();
}
