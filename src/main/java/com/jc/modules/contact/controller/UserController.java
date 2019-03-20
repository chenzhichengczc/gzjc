package com.jc.modules.contact.controller;

import com.jc.common.json.JsonResult;
import com.jc.modules.contact.entity.UserEntity;
import com.jc.modules.contact.service.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/insertUserInformation")
    public JsonResult insertUserInformation(UserEntity userEntity){
        userInformationService.insertInfo(userEntity);
        return new JsonResult();
    }

}