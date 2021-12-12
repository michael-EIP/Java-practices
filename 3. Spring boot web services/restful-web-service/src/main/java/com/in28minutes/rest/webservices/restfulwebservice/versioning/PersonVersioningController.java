package com.in28minutes.rest.webservices.restfulwebservice.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {
	
	@GetMapping("/v1/users")
	public PersonV1 getPersonV1() {
		return new PersonV1("David Teo");
	}
	
	@GetMapping("/v2/users")
	public PersonV2 getPersonV2() {
		return new PersonV2(new Name("David", "Teo"));
	}
	
	@GetMapping(value="/person/param", params = "version=1")
	public PersonV1 getPersonParamV1() {
		return new PersonV1("David Teo");
	}
	
	@GetMapping(value="/person/param", headers = "X-API-VERSION=2")
	public PersonV2 getPersonParamV2() {
		return new PersonV2(new Name("David", "Teo"));
	}
	
	
}
