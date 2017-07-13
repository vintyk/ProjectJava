package by.ecp.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by User on 13.07.2017.
 */
@Aspect
public class AnnotationAspect {

    @Before("@annotation(by.ecp.services.Loggable)")
    public void gameListBefore(){
        System.out.println("====================== Begin method:  =========================");
    }
    @After("@annotation(by.ecp.services.Loggable)")
    public void gameListAfter(){
        System.out.println("====================== End method:  ===========================");
    }
    @Around("@annotation(by.ecp.services.Loggable)")
    public Object gameListBefore(ProceedingJoinPoint pjp)throws Throwable{
        System.out.println("====================== Around method: =========================");
        Object retVal = pjp.proceed();
        return retVal;
    }
}
