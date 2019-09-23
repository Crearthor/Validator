package pl.Validation.walidacjaZadanie;

import javax.validation.constraints.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@DaneCoherent
public class Dane {

    @NotEmpty
    @Size(min = 3)
    @Pattern(regexp = "[A-Z][a-z]+",message = "Imie musi sie zaczynac od duzej litery i zawierac tylko litery")
    private String name;

    @Email
    private String email;

    @NotEmpty
    @Pattern(regexp = "[0-9]{4}(-[0-9]{2}){2} [0-9]{2}:[0-9]{2}",message = "Data musi miec format YYYY-MM-DD HH:mm")
    private String textDate;

    @Past

    private LocalDateTime date;

    public Dane(@NotEmpty @Size(min=3) @Pattern(regexp = "[A-Z][a-z]+") String name, @Email String email, @NotEmpty @Pattern(regexp = "[0-9]{4}(-[0-9]{2}){2} [0-9]{2}:[0-9]{2}") String textDate, @Past LocalDateTime date){
        this.name = name;
        this.email = email;
        this.textDate = textDate;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        try{
            this.date = LocalDateTime.parse(textDate,formatter);
        }catch (DateTimeParseException e){
            this.date = LocalDateTime.of(1,1,1,1,1);
        }


    }


    public LocalDateTime getDate(){
        return date;
    }
}
