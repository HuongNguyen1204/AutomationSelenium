package helpers;

import com.github.javafaker.Faker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataHelper {
    private static Faker faker = new Faker();

    public static String randomEmail() {
        return faker.internet().emailAddress();
    }

    public static String randomText() {
        return faker.letterify("??????");
    }

    public static String randomUrl() { return faker.internet().url(); }
}
