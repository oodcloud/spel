package com.tg.spel.rule;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author wangyujie
 */
@Slf4j
public class RuleMain {
    private static List<Order> orders = new ArrayList<Order>() {{
        //年龄19，不是新客，周一下单，金额80
        add(new Order("A",
                19,
                false,
                LocalDate.of(2021, 5, 17),
                new BigDecimal(80)));
        //年龄17，是新客，周五下单，金额19
        add(new Order("B",
                17,
                true,
                LocalDate.of(2021, 5, 21),
                new BigDecimal(19)));
        //年龄17，不是新客，周六下单，金额9
        add(new Order("C",
                17,
                true,
                LocalDate.of(2021, 11, 22),
                new BigDecimal(9)));
    }};

    private static  List<SpelRule> spelRuleList = new ArrayList<SpelRule>() {{
        add(new SpelRule(Lists.newArrayList("orderDate.getDayOfWeek().getValue() == 1 || " +
                "orderDate.getDayOfWeek().getValue() == 5", "isNew"),
                "price*0.2"));

        add(new SpelRule(Lists.newArrayList("age>18 && price>50"),
                "(price-50)*0.2"));
    }};

    public static void main(String[] args) {
        /**
         * 规则1：周一周五新客结算，优惠金额为 price  *0.2
         * 规则2: 年龄大于18岁、金额大于50的订单，优惠金额为(price - 50) * 0.2
         */
        ExpressionParser parser = new SpelExpressionParser();
        orders.forEach(
                o -> spelRuleList.forEach(sr -> {
                            List<String> filterRuleList = sr.getFilterRuleList();
                            boolean b = filterRuleList
                                    .stream()
                                    .filter(Objects::nonNull)
                                    .allMatch(r -> {
                                        Boolean value = parser.parseExpression(r).getValue(o, Boolean.class);
                                        return value == null ? false : value;
                                    });
                            if (b) {
                                BigDecimal value = parser.parseExpression(sr.getService()).getValue(o, BigDecimal.class);
                                log.info("The current order：{},successfully passed{}check，The discount value:{}", o, filterRuleList, value);
                            }
//                            else {
//                                log.info("The current order：{},not pass{}check", o, filterRuleList);
//                            }
                        }
                )
        );


    }
}
