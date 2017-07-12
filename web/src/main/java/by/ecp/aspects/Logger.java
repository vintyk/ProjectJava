package by.ecp.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by PloSkiY on 09.07.2017.
 */
@Aspect
public class Logger {

    @Pointcut ("execution(public * by.ecp.*.* (..))")
    public void webAspect() {};


    @Before("execution(public * by.ecp.*.* (..))")
    public void printParametrs() {
        System.out.println("====LoggerAspect is ON====");
    }

}
