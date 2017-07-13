package by.ecp.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.List;


/**
 * Created by PloSkiY on 09.07.2017.
 */
@Aspect
@Component
public class Logger {

//    @Around("execution(* *(..)) && @annotation(by.ecp.services.Loggable)")
//    public void methodLog(ProceedingJoinPoint proceedingJoinPoint)throws Throwable{
//        System.out.println("====================== Around method: =========================");
//        System.out.println("Beginning execution for "+proceedingJoinPoint.getSignature().getName());
//        long start = System.currentTimeMillis();
//        proceedingJoinPoint.proceed();
//        long end = System.currentTimeMillis();
//        long res = end-start;
//        System.out.println("Execution completed for "+proceedingJoinPoint.getSignature().getName());
//        System.out.println("Время выполнения: " + res);
//    }

    @Before("execution(* *(..)) && @annotation(by.ecp.services.Loggable)")
    public void logBefore(JoinPoint joinPoint) {
        String ascColorsBegin = (char)27 + "[34;43m";
        String ascColorsEnd = (char)27 + "[0m";

        System.out.println(ascColorsBegin+"*************************************************************************************************"+ascColorsEnd);
        System.out.printf(ascColorsBegin+"Вызываем в сервисе "+
                joinPoint.getThis().toString()+
                " метод: "+joinPoint.getSignature().getName()+ascColorsEnd+"\n");
        System.out.println(ascColorsBegin+"*************************************************************************************************"+ascColorsEnd);
    }
    @AfterReturning(
            pointcut = "@annotation(by.ecp.services.Loggable)",
            returning= "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        String ascColorsBegin = (char)27 + "[34;43m";
        String ascColorsEnd = (char)27 + "[0m";
        List<Object> newObj = (List<Object>) result;
        int num = 1;
        for (Object o : newObj
        ){
            System.out.println("перехват : " + joinPoint.getSignature().getName()+" Запись № "+ num++);
            System.out.println(ascColorsBegin+"***************************************************************"+ascColorsEnd);
            System.out.println(ascColorsBegin+ o +ascColorsEnd);
            System.out.println(ascColorsBegin+"***************************************************************"+ascColorsEnd);
        }

    }
}
