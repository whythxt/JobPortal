package com.whythat.JobPortal.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    // return-type class-name.method-name(args)
    @Before("execution (* com.whythat.JobPortal.services.JobService.getJob(..))")
    public void logMethodCall(JoinPoint jp) {
        LOGGER.info("Method Called " + jp.getSignature().getName());
    }

    @After("execution (* com.whythat.JobPortal.services.JobService.getJob(..)) ||" +
            " execution (* com.whythat.JobPortal.services.JobService.getJob(..))")
    public void logMethodExecuted(JoinPoint jp) {
        LOGGER.info("Method Executed " + jp.getSignature().getName());
    }

    @AfterThrowing("execution (* com.whythat.JobPortal.services.JobService.getJob(..)) ||" +
            " execution (* com.whythat.JobPortal.services.JobService.getJob(..))")
    public void logMethodCrashed(JoinPoint jp) {
        LOGGER.info("Method had some issues " + jp.getSignature().getName());
    }



    @AfterReturning("execution (* com.whythat.JobPortal.services.JobService.getJob(..)) ||" +
            " execution (* com.whythat.JobPortal.services.JobService.getJob(..))")
    public void logMethodExecutedSuccess(JoinPoint jp) {
        LOGGER.info("Method Executed Successfully " + jp.getSignature().getName());
    }
}
