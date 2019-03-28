package com.jc.modules.contact.controller;

import com.jc.common.utils.ResponseUtil;
import com.jc.common.utils.TextValidator;
import com.jc.modules.contact.entity.UserEntity;
import com.jc.modules.contact.service.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : ChenHsingLou
 * @date : 2019/3/18 15:33
 * @description : 用户信息controller
 * @version :
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserInformationService userInformationService;

    @RequestMapping(value = "/insertUserInformation",method = RequestMethod.POST)
    public ResponseUtil insertUserInformation(UserEntity userEntity) {

        if(!TextValidator.checkName(userEntity.getUsername())){
            return ResponseUtil.error("姓名错误");
        }else if(!TextValidator.checkPhone(userEntity.getPhone())){
            return ResponseUtil.error("手机号码不正确");
        }else if(!TextValidator.checkEmail(userEntity.getEmail())) {
            return ResponseUtil.error("邮箱不正确");
        }else if(userEntity.getMessage().length() ==0){
            return ResponseUtil.error("信息不能为空");
        }else{
            userInformationService.insertInfo(userEntity);
        }
        return ResponseUtil.success();
    }

}
