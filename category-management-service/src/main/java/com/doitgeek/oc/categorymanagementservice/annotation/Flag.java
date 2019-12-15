package com.doitgeek.oc.categorymanagementservice.annotation;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Validates given flag. Flag must be 'Y' => Yes OR 'N' => No.
 */

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FlagValidator.class)
@Documented
public @interface Flag {
    String message() default "Flag must be valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        Flag[] value();
    }
}

class FlagValidator implements ConstraintValidator<Flag, Character> {

    @Override
    public void initialize(Flag constraintAnnotation) {
    }

    @Override
    public boolean isValid(Character flag, ConstraintValidatorContext context) {
        if (flag == null)
            return true;
        return flag.equals('Y') || flag.equals('N');
    }
}
