package com.jc.modules.contact.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jc.common.exception.JcException;
import com.jc.modules.contact.entity.UserEntity;
import com.jc.modules.contact.mapper.UserInformationMapper;
import com.jc.modules.contact.service.UserInformationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UserInformationServiceImpl extends ServiceImpl<UserInformationMapper , UserEntity> implements UserInformationService {

    @Resource
    private UserInformationMapper userInformationMapper;

    @Override
    public void insertInfo(UserEntity userEntity){
        Integer insertResult = userInformationMapper.insert(userEntity);
        if(insertResult!=1){
            throw new JcException("用户信息插入失败");
        }
    }
}
