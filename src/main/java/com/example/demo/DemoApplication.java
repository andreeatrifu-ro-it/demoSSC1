package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class DemoApplication {

    static Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
    // wwwwaaadexxxxxx, aaaabbbccc, abbbcdddd, aaaabbbcccaaaaajjoppp
    encodeExpression("wwwwaaadexxxxxx");
    // w4a3d1e1x6, a1b3c1d4, a4b3c3, a4b3c3a5j2o1p3
}

    public static void encodeExpression(String expressionToEncode){
        logger.debug("Expression to encode: {}", expressionToEncode);
        ListIterator<Character> charListIterator = expressionToEncode.chars()
                .mapToObj(c -> (char) c)
                .toList().listIterator();

        StringBuilder encodedResult = new StringBuilder();
        Integer countSameCh = 1;
        while(charListIterator.hasNext()) {
            Character currCh = charListIterator.next();
            if(charListIterator.hasNext()) {
                Character nextCh = charListIterator.next();
                logger.debug("currCh: {} nextCh: {}", currCh, nextCh);
                if (currCh.equals(nextCh)) {
                    countSameCh++;
                } else {
                    createEncodedResult(currCh, countSameCh, encodedResult);
                    countSameCh = 1;
                }
                charListIterator.previous();
            } else {
                 createEncodedResult(currCh, countSameCh, encodedResult);
            }
        }
        logger.debug("Encoded expression: {}", encodedResult);
    }

    public static void createEncodedResult(Character key, Integer value, StringBuilder encodedResult){
        encodedResult.append(key).append(value);
    }

}
