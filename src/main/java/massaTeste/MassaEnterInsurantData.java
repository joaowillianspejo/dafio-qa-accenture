package massaTeste;

import java.util.Locale;

import com.github.javafaker.Faker;

public class MassaEnterInsurantData {
	static Faker faker = new Faker(new Locale("en-US"));
	public static final String FIRST_NAME = faker.name().firstName();
	public static final String LAST_NAME = faker.name().lastName();
	public static final String DATE_OF_BIRTH = "09/16/1996";
	public static final String STREET_ADDRESS = faker.address().streetAddress();
	public static final String COUNTRY = "Brazil";
	public static final String ZIP_CODE = faker.address().zipCode();
	public static final String CITY = faker.address().city();
	public static final String OCCUPATION = "Employee";
	public static final String WEBSITE = faker.internet().url();
}
