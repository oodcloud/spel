package com.tg.spel;

import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @author wangyujie
 */
public class App {
    public static void main(String[] args) {
        // 1. 构建解析器
        org.springframework.expression.ExpressionParser parser = new SpelExpressionParser();
        // 2. 解析表达式
        Expression expression = parser.parseExpression("100 * 2 + 400 * 1 + 66");
        System.out.println(expression.toString());
        // 3. 获取结果
        int result = (Integer) expression.getValue();
        System.out.println(result); // 结果：
    }
}
