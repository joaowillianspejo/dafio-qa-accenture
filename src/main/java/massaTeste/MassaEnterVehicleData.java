package massaTeste;

import java.util.Locale;

import com.github.javafaker.Faker;

public class MassaEnterVehicleData {
	static Faker faker = new Faker(new Locale("en-US"));
	public static final String MAKE = "BMW";
	public static final String MODEL = "Motorcycle";
	public static final String CYLINDER_CAPACITY = String.valueOf(faker.number().numberBetween(1, 2000));
	public static final String ENGINE_PERFORMANCE = String.valueOf(faker.number().numberBetween(1, 2000));
	public static final String DATE_OF_MANUFACTURE = "01/23/1990";
	public static final String NUMBER_OF_SEATS = String.valueOf(faker.number().numberBetween(1, 9));
	public static final String NUMBER_OF_SEATS_MOTORCYCLE = String.valueOf(faker.number().numberBetween(1, 3));
	public static final String FUEL_TYPE = "Gas";
	public static final String PAYLOAD = String.valueOf(faker.number().numberBetween(1, 1000));
	public static final String TOTAL_WEIGHT = String.valueOf(faker.number().numberBetween(100, 50000));
	public static final String LIST_PRICE = String.valueOf(faker.number().numberBetween(500, 100000));
	public static final String LICENSE_PLATE_NUMBER = "ABC-1234";
	public static final String ANNUAL_MILEAGE = String.valueOf(faker.number().numberBetween(100, 100000));
}
