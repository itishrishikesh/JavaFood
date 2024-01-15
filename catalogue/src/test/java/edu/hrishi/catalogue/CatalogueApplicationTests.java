package edu.hrishi.catalogue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@SpringBootTest
class CatalogueApplicationTests {

	@Test
	void contextLoads() {
		ConcurrentHashMap<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();
		concurrentHashMap.put(1, "joker");
	}

}
