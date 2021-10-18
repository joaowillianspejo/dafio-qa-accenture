package massaTeste;

import java.util.Locale;

import com.github.javafaker.Faker;

public class MassaEnterProductData {
	static Faker faker = new Faker(new Locale("en-US"));
	public static final String START_DATE = "01/15/2022";
	public static final int INSURANCE_SUM = faker.number().numberBetween(1, 9);
	public static final int MERIT_RATING = faker.number().numberBetween(1, 17);
	public static final int DAMAGE_INSURANCE = faker.number().numberBetween(1, 3);
	public static final int COURTESY_CAR = faker.number().numberBetween(1, 2);
}
