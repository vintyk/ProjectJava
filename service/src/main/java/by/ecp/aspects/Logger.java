package by.ecp.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;




/**
 * Created by PloSkiY on 09.07.2017.
 */
@Aspect
public class Logger {

    @Around("execution(* *(..)) && @annotation(by.ecp.services.Loggable)")
    public Object methodLog(ProceedingJoinPoint point)throws Throwable{
        System.out.println("====================== Around method: =========================");
        long start = System.currentTimeMillis();
        Object result = point.proceed();
        return result;
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
