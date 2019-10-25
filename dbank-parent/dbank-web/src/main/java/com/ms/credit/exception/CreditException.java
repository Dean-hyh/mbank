package com.ms.credit.exception;

//import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreditException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //TODO 权限相关的配置
        //if (ex instanceof UnauthorizedException) {
        //    //异常为UnauthorizedException时，转发请求至指定页面,不走springMVC中自定义的视图解析器
        //    return new ModelAndView("forward:/unauthorized.jsp");
        //} else {
            ModelAndView mv = new ModelAndView();
            mv.setViewName("error");
            mv.addObject("errorMsg", "⚠服务器遇到了一点异常" + ex.getMessage());
            return mv;
        //}
    }
}
