package by.ecp.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.io.*;
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
    File myFile = new File("log4j.log");
    @Before("execution(* *(..)) && @annotation(by.ecp.services.Loggable)")
    public void logBefore(JoinPoint joinPoint) {

        try {
            PrintWriter writer =
                    new PrintWriter(new BufferedWriter(new FileWriter(myFile, true)));
            writer.println("Вызываем в сервисе " + joinPoint.getThis().toString() +
                    " метод: " + joinPoint.getSignature().getName() + ascColorsEnd + "\n");
            writer.println("с параметрами:   " + Arrays.toString(joinPoint.getArgs()));
            writer.flush();
            writer.close();

        System.out.println(ascColorsBegin + "*********************************************" +
                "***************************************************************" + ascColorsEnd);
        System.out.printf(ascColorsBegin + "Вызываем в сервисе " +
                joinPoint.getThis().toString() +
                " метод: " + joinPoint.getSignature().getName() + ascColorsEnd + "\n");
        System.out.println(ascColorsBeginRed + "с параметрами:   " + Arrays.toString(joinPoint.getArgs()) + ascColorsEnd);
        System.out.println(ascColorsBegin + "*******************************************************" +
                "*****************************************************" + ascColorsEnd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterReturning(
            pointcut = "@annotation(by.ecp.services.Loggable)",
            returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        int numRecFile = 1;
        File myFile = new File("log4j.log");
//        try {
//            PrintWriter writer =
//                    new PrintWriter(new BufferedWriter(new FileWriter(myFile, true)));

            List<Object> newObj = (List<Object>) result;
            int num = 1;
            for (Object o : newObj
                    ) {
                System.out.println(ascColorsBeginRed + "перехват : " + joinPoint.getSignature().getName() + " Запись № " + num++ + ascColorsEnd);
                numRecFile = num;
//                writer.println("перехват : " + joinPoint.getSignature().getName() + " Запись № " + numRecFile);
//                writer.println("Аргументы : " + Arrays.toString(joinPoint.getArgs()));
//                writer.println("Аргументы : " + joinPoint.getSignature());
//                writer.println(o.toString());
                System.out.println(ascColorsBeginRed + "Аргументы : " + Arrays.toString(joinPoint.getArgs()) + ascColorsEnd);
                System.out.println(ascColorsBeginRed + "Аргументы : " + joinPoint.getSignature() + ascColorsEnd);
                System.out.println(ascColorsBegin + "***************************************************************" + ascColorsEnd);
                System.out.println(ascColorsBegin + o + ascColorsEnd);
                System.out.println(ascColorsBegin + "***************************************************************" + ascColorsEnd);
            }
//            writer.flush();
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

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

