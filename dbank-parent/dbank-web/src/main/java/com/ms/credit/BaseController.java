package com.ms.credit;

import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * @author Dean
 * @version 1.0
 * @date 2019/10/28 14:31
 */
public class BaseController {

    protected HttpServletRequest request;

    protected HttpServletResponse response;

    protected HttpSession session;

    /**
     * @param request
     * @param response
     * @param session
     * attribute注解的方法在子类方法执行的之前执行
     */
    @ModelAttribute
    public void setRequestAndResponse(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        this.request = request;
        this.response = response;
        this.session = session;
    }
}
