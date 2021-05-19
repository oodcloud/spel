package com.tg.spel.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
/**
 * @author wangyujie
 */
@Documented
@Retention(RUNTIME)
@Target({METHOD, FIELD, TYPE})
@Repeatable(value = SpelValid.SpelValidList.class)
@Constraint(validatedBy = SpelValidator.class)
public @interface SpelValid {

    String message() default "{com.tg.spel.validator.spring.SpELAssert.message}";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String value();

    String applyIf() default "";

    Class<?>[] helpers() default { };

    @Documented
    @Retention(RUNTIME)
    @Target({METHOD, FIELD, TYPE})
    @interface SpelValidList {
        SpelValid[] value();
    }
}
