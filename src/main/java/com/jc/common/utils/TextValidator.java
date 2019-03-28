package com.jc.common.utils;

public final class TextValidator {

    public TextValidator(){
        super();
    }

    /**
     * 手机号码正则表达式
     */
    public static final String REGEX_PHONE = "((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}";
    /**
     * 邮箱正则表达式
     */
    public static final String REGEX_EMAIL	=	"[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+";
    /**
     * 姓名正则表达式
     */
    public static final String REGEX_NAME = "^[\\u4e00-\\u9fa5]+(·[\\u4e00-\\u9fa5]+)*$";

    public static boolean checkPhone(String phone){
        if(phone == null){
            return false;
        }
        return phone.matches(REGEX_PHONE);
    }

    public static boolean checkEmail(String email){
        if(email == null){
            return false;
        }
        return email.matches(REGEX_EMAIL);
    }

    public static boolean checkName(String name){
        return name.matches(REGEX_NAME);
    }

}
