package pl.Validation.walidacjaZadanie;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DaneCogerentValidator implements ConstraintValidator<DaneCoherent,Dane> {

    @Override
    public boolean isValid(Dane dane, ConstraintValidatorContext context){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dane.getDate());
        return dane.getDate().isBefore(now.minusYears(4));
    }
}
