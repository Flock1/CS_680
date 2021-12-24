package hw13;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Comparator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MileageComparatorReverseTest {

	private static LinkedList<Car> cars = new LinkedList<Car>();
	
	private String[] CarToString(Car c) {
		String[] info = {c.getModel(), c.getMake(), Integer.toString(c.getYear()) , Float.toString(c.getPrice()), Integer.toString(c.getMileage())};
		return info;
	}
	
	@BeforeAll
    private static void setUpOfCarsReverse() {
		
		Car c1 = new Car("800","Maruti",1991,2000,10000);
		cars.add(c1);
		Car c2 = new Car("Sumo", "Tata",1989,5000, 6000);
		cars.add(c2);
		Car c3 = new Car("Balino","Mahindra", 2001, 10000, 8000);
		cars.add(c3);
		Car c4 = new Car("City","Honda",2002,8000,9000);
		cars.add(c4);
		Car c5 = new Car("Celerio","Maruti",2005,10000,12000);
		cars.add(c5);
        Collections.sort(cars,(Car C1, Car C2) -> Comparator.comparing(Car::getMileage).reversed().compare(C1, C2));
    }

    @Test
	public void getMileageReverse() {
		String[] expected = {"Celerio", "Maruti", "2005", "10000.0", "12000"};
		String[] actual = CarToString(cars.get(0));
		assertArrayEquals(expected, actual);
	}

}