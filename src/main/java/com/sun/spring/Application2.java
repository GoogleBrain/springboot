package com.sun.spring;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class Application2 {

	@RequestMapping("/hu/")
	Map<String, String> home() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "huzaibin");
		map.put("age", "12");
		return map;
	}
}