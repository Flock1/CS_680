package hw05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

    private String[] carToStringArray(Car car) {
        String[] carStringArray = new String[5];
        carStringArray[0] = car.getMake();
        carStringArray[1] = car.getModel();
        carStringArray[2] = Integer.toString(car.getMileage());
        carStringArray[3] = Integer.toString(car.getYear());
        carStringArray[4] = Float.toString(car.getPrice());
        return carStringArray;
    }
    

    @Test
    void verifyCarEqualityWithMakeModelYear() {
        Car car1 = new Car("Toyota", "RAV4", 12, 2015, 120000);
        Car car2 = new Car("Toyota", "RAV4", 12, 2015, 120000);
        assertEquals(car1.getMake(), car2.getMake());
        assertEquals(car1.getModel(), car2.getModel());
        assertEquals(car1.getYear(), car2.getYear());

    }
    @Test
	public void verifyNotEqualCarWithMakeModelYear() {
		String[] expected = {"BMW", "M5 competition", 12, 2015, 120000};
		Car actual = new Car("Audi", "RS5", 13, 2020, 110000);
		assertNotEquals(expected, carToStringArray(actual));
	}
	

}
