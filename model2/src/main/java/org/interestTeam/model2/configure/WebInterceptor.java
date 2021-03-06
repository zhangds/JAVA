package org.interestTeam.model2.configure;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author dongshengzhang
 * @category 自定义拦截器
 */
@Component
public class WebInterceptor implements HandlerInterceptor {
    
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//		  String url = request.getRequestURL().toString();
//        String method = request.getMethod();
//        String uri = request.getRequestURI();
//        String queryString = request.getQueryString();
//        System.out.println(request.getParameterMap());
//        log.info(String.format("请求参数, url: %s, method: %s, uri: %s, params: %s ,contextPath: %s", url, method, uri, queryString,request.getContextPath()));
        request.setAttribute("mvcPath", request.getContextPath());
        return true;
	}
    
    
}