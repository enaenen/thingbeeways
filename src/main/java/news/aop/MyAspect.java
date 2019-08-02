package com.antybeety.news.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class MyAspect {
    static final Log logger = LogFactory.getLog(MyAspect.class);

    @Pointcut("execution(* com.antybeety.news.controller.*.*(..))")     //모든 파일의 구성 요소를 가지고 시작
    public void testPointcut(){
    }

    @Around("testPointcut()")       //포인트컷이 작동하면 발동 (발동조건)
    public Object checkTime(ProceedingJoinPoint pjp) throws Throwable{
        long startTime = System.nanoTime();
        // ... before members -> excute members
        HttpServletRequest request =        //현재 누가 호출했는지
                ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
        logger.info(String.format("REQUEST URI : %s"),request.getRequestURI()));
        Object retVal = pjp.proceed();      //홀딩되어있던 작업을 진행
        long endTime=System.nanoTime();
        logger.info(String.format("Elapse time: %s", endTime));
    }
}
