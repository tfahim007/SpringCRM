package com.tahmid.springcrud.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * @author Tahmidul Islam
 */
@Aspect
@Component
public class CRMLoggingAspect {
    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.tahmid.springcrud.Controller.*.*(..))")
    private void forControllerPackage(){}

    @Pointcut("execution(* com.tahmid.springcrud.dao.*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("execution(* com.tahmid.springcrud.service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage()")
    private  void forAppFlow(){}

    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint){
        String theMethod = theJoinPoint.getSignature().toShortString();
        logger.info("=========>> in @Before calling method: "+ theMethod);

        Object[] args = theJoinPoint.getArgs();

        for (Object tempArg: args){
            logger.info("===>>  arguement: "+ tempArg);
        }

    }
    @AfterReturning(pointcut = "forAppFlow()",returning = "theResult")
    public void afterReturning(JoinPoint theJoinPoint, Object theResult){
        String theMethod = theJoinPoint.getSignature().toShortString();
        logger.info("=========>> in @After from method: "+ theMethod);

        logger.info("result; "+ theResult);
    }



}
