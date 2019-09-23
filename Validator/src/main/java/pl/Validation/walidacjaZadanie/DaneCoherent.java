package pl.Validation.walidacjaZadanie;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DaneCogerentValidator.class)
public @interface DaneCoherent {
    String message() default "{pl.Validation.walidacjaZadanie.DaneCoherent.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
