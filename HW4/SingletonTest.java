package hw04;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SingletonTest {
	@Test
	public void TestNull() {
		Singleton single = Singleton.getInstance();
        assertNotNull(single);
	}

	@Test
	public void TestEqual(){
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();
		assertSame(obj1, obj2);
	}
}
