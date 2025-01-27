import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class JavaFaker {

    public static String getFirstName(){

        Faker faker = new Faker();
        return faker.name().firstName();
    }

    public static String getIndianFirstName(){

        Faker faker = new Faker(new Locale("en-IND"));
        return faker.name().firstName();
    }

    public static String getIndianLastName(){

        Faker faker = new Faker(new Locale("en-IND"));
        return faker.name().lastName();
    }
    public static String getEmail(){

        Faker faker = new Faker(new Locale("en-IND"));
        return faker.name().firstName()+"@gmail.com";
    }


    public static String getMobileNumber(){

        Faker faker = new Faker();
        return faker.number().digits(10);
    }

    public static void main(String[] args) {

       System.out.println(getFirstName());
       System.out.println(getIndianFirstName());
       System.out.println(getEmail());
       System.out.println(getMobileNumber());

    }

    public static String dateOfBirth() {
        Faker faker = new Faker();
        // Generate a random date of birth
        Date randomDate = faker.date().birthday(18, 56);
        // Convert Date to LocalDate
        LocalDate localDate = randomDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        // Format LocalDate to yyyy-MM-dd
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        return localDate.format(formatter);
    }


}
