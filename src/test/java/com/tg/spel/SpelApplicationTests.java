package com.tg.spel;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

@SpringBootTest
class SpelApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void test1(){
        ExpressionParser ep= new SpelExpressionParser();
        System.out.println(ep.parseExpression("#{'HelloWorld'}").getValue());
        System.out.println(ep.parseExpression("0xffffff").getValue());
        System.out.println(ep.parseExpression("1.234345e+3").getValue());
        System.out.println(ep.parseExpression("new java.util.Date()").getValue());
    }


}
