package com.tg.spel.rule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author wangyujie
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String userId;
    private Integer age;
    private Boolean isNew;
    private LocalDate orderDate;
    private BigDecimal price;



    @Override
    public String toString() {
        return "Order{" +
                "userId='" + userId + '\'' +
                ", age=" + age +
                ", isNew=" + isNew +
                ", orderDate=" + orderDate +
                ", price=" + price +
                '}';
    }
}
