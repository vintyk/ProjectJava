package by.ecp.entity.temp.spring;

import by.ecp.RootConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * Created by Vinty on 14.06.2017.
 */
public class SpringMain{
    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context
//                = new AnnotationConfigApplicationContext(RootConfig.class);

        String ascColorsBegin = (char) 27 + "[34;43m";
        String ascColorsBeginRed = (char) 27 + "[35m";
        String ascColorsEnd = (char) 27 + "[0m";

        System.out.println(ascColorsBeginRed+"с параметрами: "  + "вот тут переменные" + ascColorsEnd);
    }
}
