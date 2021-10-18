package massaTeste;

import java.util.Locale;

import com.github.javafaker.Faker;

public class MassaSendQuote {
	static Faker faker = new Faker(new Locale("en-US"));
	public static final String EMAIL = faker.internet().emailAddress();
	public static final String PHONE = faker.phoneNumber().phoneNumber();
	public static final String USERNAME = faker.internet().domainName();
	public static final String PASSWORD = faker.internet().password();
}
