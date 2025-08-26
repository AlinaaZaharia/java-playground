package org.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger LOG = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* org.demo.service.FreightManagementService.*(..))")
    public void beforeMethodExecution(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        LOG.info("Called " + methodName);
    }

    @AfterReturning(pointcut = "execution(* org.demo.service.FreightManagementService.*(..))",
                    returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("\n");
        if(result != null){
            System.out.println("Called " + methodName + ". Result: " + result );
        } else{
            System.out.println("Called " + methodName + ". No result returned.");
        }
    }

    @AfterThrowing(pointcut = "execution(* org.demo.service.FreightManagementService.*(..))",
                    throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Exception thrown from " + methodName + ": " +
                exception.getMessage());
    }

    @Around("execution(* org.demo.service.FreightManagementService.*(..))")
    public Object aroundMethodExecution(ProceedingJoinPoint joinPoint) throws
            Throwable {
        String methodName = joinPoint.getSignature().getName();
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        System.out.println("Method " + methodName + " execution time: " + (endTime - startTime) + " ms");
        return result;
    }
}
