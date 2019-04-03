package com.jc.modules.contact.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jc.common.exception.JcException;
import com.jc.common.utils.TextValidator;
import com.jc.modules.contact.entity.UserEntity;
import com.jc.modules.contact.mapper.UserInformationMapper;
import com.jc.modules.contact.service.UserInformationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInformationServiceImpl extends ServiceImpl<UserInformationMapper, UserEntity> implements UserInformationService {

    @Resource
    private UserInformationMapper userInformationMapper;

    @Override
    public void insertInfo(UserEntity userEntity) {
        if (!TextValidator.checkName(userEntity.getUsername())) {
            throw new JcException("名字格式错误");
        } else if (!TextValidator.checkPhone(userEntity.getPhone())) {
            throw new JcException("号码格式错误");
        } else if (!TextValidator.checkEmail(userEntity.getEmail())) {
            throw new JcException("邮箱格式错误");
        }
//        else if (userEntity.getOccupation() == null || userEntity.getOccupation() == "") {
//            throw new JcException("职业为空");
//        } else if (userEntity.getMessage() == null || userEntity.getMessage() == "") {
//            throw new JcException("信息为空");
//        }
        userInformationMapper.insert(userEntity);
    }
}
