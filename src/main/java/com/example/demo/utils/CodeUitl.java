package com.example.demo.utils;

import javax.servlet.http.HttpServletRequest;

public class CodeUitl {


    /**
     * 获取请求参数
     * @param httpServletRequest
     * @param key
     * @return
     */
    public static String getString(HttpServletRequest httpServletRequest, String key){
        try{
            String result = httpServletRequest.getParameter(key);
            return result!= null ? result : null;
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 验证码校验
     * @param request
     * @return
     */
    public static boolean checkVerifyCode(HttpServletRequest request){

        String expected = (String)request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);

        // 获取用户输入的验证码

        String actual = CodeUitl.getString(request,"verifyCodeActual" );
        if(expected.equals(actual)){
            return true;
        }
        return false;
    }
}
