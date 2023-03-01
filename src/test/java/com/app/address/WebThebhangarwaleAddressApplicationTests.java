package com.app.address;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.function.Function;

@SpringBootTest
class WebThebhangarwaleAddressApplicationTests {

	@Test
	void contextLoads() {
		try{
			Object msg = Optional.ofNullable(null).map(new Function<Object, Object>() {
				@Override
				public Object apply(Object o) {
					return "Hello";
				}
			}).get();

			System.out.println(msg);
		}catch (Exception ex){
			System.out.println(ex.getMessage());
		}
	}

}
