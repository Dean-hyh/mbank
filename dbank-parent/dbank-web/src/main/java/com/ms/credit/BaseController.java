package com.ms.credit;

import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class BaseController {
    //@Autowired
    protected HttpServletRequest request;
    //@Autowired
    protected HttpServletResponse response;
    //@Autowired
    protected HttpSession session;

    @ModelAttribute  //attribute注解的方法在子类方法执行的之前执行
    public void setRequestAndResponse(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        this.request = request;
        this.response = response;
        this.session = session;
    }
}
