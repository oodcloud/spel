package com.tg.spel.base;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

/**
 * @author wangyujie
 */
public class SpelTest {
    public static void main(String[] args) {
        //文本表达式类型支持字符串、数值（整型、浮点型、十六进制等）、布尔型、和 null，字符串使用单引号定义
        ExpressionParser parser = new SpelExpressionParser();
        String helloWorld = (String) parser.parseExpression("'Hello World'").getValue();
        double avogadrosNumber = (double) parser.parseExpression("6.0221415E+23").getValue();
        int maxValue = (int) parser.parseExpression("0x7FFFFFFF").getValue();
        boolean trueValue = (boolean) parser.parseExpression("true").getValue();
        Object nullValue = parser.parseExpression("null").getValue();
        //属性、数组 、集合
        EvaluationContext context = SimpleEvaluationContext.forReadWriteDataBinding().build();

        //https://mp.weixin.qq.com/s/XO4UtoKjexdqfzA_n-Fcyw
        //https://zhuanlan.zhihu.com/p/174786047

//        Birthdate birthdate = new Birthdate();
//        birthdate.setYear(2021);
//        context.setVariable("birthdate",birthdate);
//        PlaceOfBirth placeOfBirth = new PlaceOfBirth();
//        placeOfBirth.setCity("DALIAN");
//        context.setVariable("placeOfBirth",placeOfBirth);

//        int year = (Integer) parser.parseExpression("Year + 1900").getValue(birthdate);
//
//        String city = (String) parser.parseExpression("City").getValue(placeOfBirth);

        System.out.println( parser.parseExpression("'DALIAN'+(1+1)").getValue());
    }
}
