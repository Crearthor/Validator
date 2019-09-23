package pl.Validation.walidacjaZadanie;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Scanner;
import java.util.Set;

public class Walidacja {
    private Validator validator;

    public Walidacja(){
        ValidatorFactory validationFactory = Validation.buildDefaultValidatorFactory();
        validator = validationFactory.getValidator();
    }

    public static void main(String[] args) {

        Walidacja walidacja = new Walidacja();
        walidacja.showDaneValidation();

    }

    private void showDaneValidation(){
        Scanner input = new Scanner(System.in);
        String name;
        String email;
        String textDate;

        System.out.println("Podaj swoje imie: ");
        name = input.nextLine();

        System.out.println("Podaj swoj email: ");
        email = input.nextLine();

        System.out.println("Podaj swoja date urodzenia: ");
        textDate = input.nextLine();

        Dane dane = new Dane(name,email,textDate, null);

        Set<ConstraintViolation<Dane>> validationsErrors = validator.validate(dane);
        for(ConstraintViolation<Dane> validationError : validationsErrors){
            System.out.println(validationError.getPropertyPath().toString()+ " "+ validationError.getMessage());
        }
    }

}
