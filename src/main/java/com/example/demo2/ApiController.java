package com.example.demo2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import lombok.Data;

@RestController
@RequestMapping("/test")
public class ApiController {

    @Value("${test.add.env.via.openshift}")
    private String test;
    
//	@PostMapping("/post")
	@GetMapping(name = "get1",value = "get1",produces = {MediaType.APPLICATION_JSON_VALUE})
	@ApiOperation("get test without parameters")
	public User getTest() {
		
		Logger logger = LoggerFactory.getLogger(this.getClass());
		logger.info("just test");
		
		User u = new User();
		u.setName("abctest-demo3"+" " + test);
		
		return u;
	}
	
	@GetMapping(name = "getError11",value = "/user/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation("get test without parameters111")
    public User getTestError(@PathVariable int id) {
       throw new BusinessException("1001","get test error");
    }
	
}

@Data
class User{
    private String name;
}