package by.ecp.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


/**
 * Created by PloSkiY on 09.07.2017.
 */
@Aspect
@Component
public class Logger {

    @Around("execution(* *(..)) && @annotation(by.ecp.services.Loggable)")
    public void methodLog(ProceedingJoinPoint proceedingJoinPoint)throws Throwable{
        System.out.println("====================== Around method: =========================");
        System.out.println("Beginning execution for "+proceedingJoinPoint.getSignature().getName());
        long start = System.currentTimeMillis();
        proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        long res = end-start;
        System.out.println("Execution completed for "+proceedingJoinPoint.getSignature().getName());
        System.out.println("Время выполнения: " + res);
    }

    @Before("@annotation(by.ecp.services.Loggable)")
    public void gameListBefore(){
        System.out.println("====================== Begin method:  =========================");
    }
    @After("@annotation(by.ecp.services.Loggable)")
    public void gameListAfter(){
        System.out.println("====================== End method:  ===========================");
    }
}
