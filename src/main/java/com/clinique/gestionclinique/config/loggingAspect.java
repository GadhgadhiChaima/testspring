package com.clinique.gestionclinique.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.*;


@Aspect
@Component



public class loggingAspect {

    private static final Logger l=LogManager.getLogger(loggingAspect.class);
    @After("execution(*   com.clinique.gestionclinique.service.ServiceProjetImpl.add*(..))")
    public void logMethodeExit(JoinPoint joinPoint) {
        l.info("methode execute");
    }

        @Before("execution(*   com.clinique.gestionclinique.service.ServiceProjetImpl.add*(..))")
        public void logMethodeEntry(JoinPoint joinPoint){
            l.info("methode execute");

    }
    @Around("execution(*   com.clinique.gestionclinique.service.ServiceProjetImpl.add*(..))")
    public Object profile(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start=System.currentTimeMillis();
        Object obj=proceedingJoinPoint.proceed();
        long elapsedTime=System.currentTimeMillis()-start;
        l.info("Around methode: execution:"+elapsedTime);
        return obj;

    }
}
