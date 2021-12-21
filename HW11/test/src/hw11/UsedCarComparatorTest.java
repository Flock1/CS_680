package hw11;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.Test;

class UsedCarComparatorTest {

	ArrayList<Car>cars = new ArrayList<>();
	
	@Test
	public void MileageComparator() {
		ArrayList<Integer> actual = new ArrayList<>();
		ArrayList<Integer> expected = new ArrayList<>();
		
		cars.add(new Car("800","Maruti",1991,2000,10000));
		cars.add(new Car("Sumo", "Tata",1989,5000, 6000));
		cars.add(new Car("Balino","Mahindra", 2001, 10000, 8000));
		cars.add(new Car("City","Honda",2002,8000,9000));
		cars.add(new Car("Camry","Toyota",2005,9000,6500));
		Collections.sort(cars, new MileageComparator());
		
		expected.add(10000);
		expected.add(9000);
		expected.add(8000);
		expected.add(6500);
		expected.add(6000);

		
		for(Car c: cars) {
			actual.add(c.getMileage());
		}
		assertEquals(actual, expected);	
	}
	
	@Test
	public void PriceComparator() {
		ArrayList<Float> actual = new ArrayList<>();
		ArrayList<Float> expected = new ArrayList<>();
		
		cars.add(new Car("800","Maruti",1991,2000,10000));
		cars.add(new Car("Sumo", "Tata",1989,5000, 6000));
		cars.add(new Car("Balino","Mahindra", 2001, 10000, 8000));
		cars.add(new Car("City","Honda",2002,8000,9000));
		cars.add(new Car("Camry","Toyota",2005,9000,6500));
		Collections.sort(cars, new PriceComparator());
		
		expected.add((float) 10000);
		expected.add((float) 9000);
		expected.add((float) 8000);
		expected.add((float) 5000);
		expected.add((float) 2000);
		
		for(Car c: cars) {
			actual.add(c.getPrice());
		}
		assertEquals(actual, expected);	
	}
	
	@Test
	public void YearComparator() {
		ArrayList<Integer> actual = new ArrayList<>();
		ArrayList<Integer> expected = new ArrayList<>();
		
		cars.add(new Car("800","Maruti",1991,2000,10000));
		cars.add(new Car("Sumo", "Tata",1989,5000, 6000));
		cars.add(new Car("Balino","Mahindra", 2001, 10000, 8000));
		cars.add(new Car("City","Honda",2002,8000,9000));
		cars.add(new Car("Camry","Toyota",2005,9000,6500));
		Collections.sort(cars, new YearComparator());
		
		expected.add(2005);
		expected.add(2002);
		expected.add(2001);
		expected.add(1991);
		expected.add(1989);
		
		for(Car c: cars) {
			actual.add(c.getYear());
		}
		assertEquals(actual, expected);	
	}
	

}