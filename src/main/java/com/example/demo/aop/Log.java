package com.example.demo.aop;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.TableRequest;
import com.example.demo.service.TableRequestService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Objects;

/**
 * @Auther 旷彬
 * @Date 2021/3/6
 */
@Aspect
@Component
@Slf4j
public class Log {

    @Autowired
    private TableRequestService service;

    @Pointcut("execution(String com.example.demo.controller.URLController.*(..)))")
    public void AfterReturningRequest() {
    }
    @AfterReturning(pointcut = "AfterReturningRequest()",returning="segmentResult")
    public void AfterReturningRequest(JoinPoint joinPoint, String segmentResult) {
        // 获取request
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date datetime = new Date();
        log.debug("请求时间：" + dateFormat.format(datetime));
        String type = request.getContentType();
        log.debug("参数类型：" + type);
        String data = JSON.toJSONString(request.getParameterMap());
        log.debug("请求参数：" + data);
        String url = request.getRequestURL().toString();
        log.debug("请求地址：" + url);
//        String address = request.getRemoteAddr();
        // Nginx代理下使用
        String address = this.getClientIP(request);
        log.debug("用戶地址：" + address);
        //获取所有请求头名称
        Enumeration<String> headerNames = request.getHeaderNames();
        JSONObject headerOjb = new JSONObject();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            //根据名称获取请求头的值
            String value = request.getHeader(name);
            if(!name.equals("cookie"))
                headerOjb.put(name,value);
        }
        String header = headerOjb.toJSONString();
        log.debug("请求头("+header.length()+")：" + header);
        try{
            service.save(new TableRequest(null,datetime,address,url,type,header,data));
        }catch (Exception e){
            log.debug("日志写入异常："+e.getMessage());
        }
    }

    /**
     * 获取客户端IP地址;这里通过了Nginx获取;X-Real-IP
     */
    public String getClientIP(HttpServletRequest request) {
        String ip = request.getHeader("X-Real-IP");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Forwarded-For");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

}
