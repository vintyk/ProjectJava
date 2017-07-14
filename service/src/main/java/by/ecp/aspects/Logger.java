package by.ecp.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


/**
 * Created by PloSkiY on 09.07.2017.
 */
@Aspect
@Component
public class Logger {
    private String ascColorsBegin = (char) 27 + "[34;43m";
    private String ascColorsBeginRed = (char) 27 + "[35m";
    private String ascColorsEnd = (char) 27 + "[0m";

    @Before("execution(* *(..)) && @annotation(by.ecp.services.Loggable)")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println(ascColorsBegin + "************************************************************************************************************" + ascColorsEnd);
        System.out.printf(ascColorsBegin + "Вызываем в сервисе " +
                joinPoint.getThis().toString() +
                " метод: " + joinPoint.getSignature().getName() + ascColorsEnd + "\n");
        System.out.println(ascColorsBeginRed + "с параметрами:   " + Arrays.toString(joinPoint.getArgs()) + ascColorsEnd);
        System.out.println(ascColorsBegin + "************************************************************************************************************" + ascColorsEnd);
    }

    @AfterReturning(
            pointcut = "@annotation(by.ecp.services.Loggable)",
            returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        List<Object> newObj = (List<Object>) result;
        int num = 1;
        for (Object o : newObj
                ) {
            System.out.println(ascColorsBeginRed + "перехват : " + joinPoint.getSignature().getName() + " Запись № " + num++ + ascColorsEnd);
            System.out.println(ascColorsBeginRed + "Аргументы : " + Arrays.toString(joinPoint.getArgs()) + ascColorsEnd);
            System.out.println(ascColorsBeginRed + "Аргументы : " + joinPoint.getSignature() + ascColorsEnd);
            System.out.println(ascColorsBegin + "***************************************************************" + ascColorsEnd);
            System.out.println(ascColorsBegin + o + ascColorsEnd);
            System.out.println(ascColorsBegin + "***************************************************************" + ascColorsEnd);
        }

    }

    @AfterReturning(
            pointcut = "@annotation(by.ecp.services.LoggableOne)",
            returning = "result")
    public void logSaveObj(JoinPoint joinPoint, Object result) {
        System.out.println(ascColorsBeginRed + "перехват : " + joinPoint.getSignature().getName() + " Запись № " + ascColorsEnd);
        System.out.println(ascColorsBeginRed + "Аргументы : " + Arrays.toString(joinPoint.getArgs()) + ascColorsEnd);
        System.out.println(ascColorsBeginRed + "Аргументы : " + joinPoint.getSignature() + ascColorsEnd);
        System.out.println(ascColorsBegin + "***************************************************************" + ascColorsEnd);
        System.out.println(ascColorsBegin + result + ascColorsEnd);
        System.out.println(ascColorsBegin + "***************************************************************" + ascColorsEnd);
    }
}

