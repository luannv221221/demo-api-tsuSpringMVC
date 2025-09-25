package com.ra.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {UniqueValidateProductCreate.class})
public @interface Unique {
    String message() default "duplicate entry";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
