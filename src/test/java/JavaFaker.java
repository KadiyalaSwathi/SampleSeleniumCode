import com.github.javafaker.Faker;

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


}
