package pl.Validation.walidacjaZadanie;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class DaneCogerentValidator implements ConstraintValidator<DaneCoherent,Dane> {

    @Override
    public boolean isValid(Dane dane, ConstraintValidatorContext context){
        LocalDate now = LocalDate.now();
        return dane.getDate().isBefore(now.minusYears(4));
    }
}
