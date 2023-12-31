package src.main.webapp.java.org.example.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = PhoneConstraintValidator.class)
public @interface PhoneConstraint {
    String message() default "phone number is not correct ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int beginTime() default 6;

    int endTime() default 1;

}
