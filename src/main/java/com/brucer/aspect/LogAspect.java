package com.brucer.aspect;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class LogAspect {

    /**
     * 拦截 web包下所有类的所有方法
     */
    @Pointcut("execution(* com.brucer.web.*.*(..))")
    public void log() {}

    @Before("log()")
    public void doBefore (JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        RequestLog requestLog = new RequestLog(url, ip, classMethod, args);
        log.info("Request : {}",requestLog);
    }

    @After("log()")
    public void doAfter () {
//        log.info("----------doAfter----------");
    }

    @AfterReturning(returning = "result",pointcut = "log()")
    public void doAfterReturn (Object result) {
        log.info("Result : {}",result);
    }


    @Data
    @AllArgsConstructor
    public class RequestLog {
        private String url;
        private String ip;
        private String classMethod;
        private Object[] args;
    }
}
