package spring.security.controller;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.security.entities.Employee;

@RestController
public class SecurityController {
	
	@GetMapping("/getEmployees")
	public String getEmployee() {
		return "getEmployees";
	}
	
	@PostMapping("/saveEmployee")
	public Employee postEmployee(@RequestBody Employee emp) {
		return emp;
	}
	
	@PutMapping("/updateEmployee")
	public String updateEmployee(@PathVariable("name") String name,@RequestBody Employee emp) {
		return emp.toString()+"updated name"+name;
	}
	
	@GetMapping("/getPathVaraiable")
	public String getPathVar(@PathVariable("name") String name) {
		return "Path Variable"+ name;
	}
	
	@GetMapping("/request")
	public String getRequestParam(@RequestParam(name="name",required = true,defaultValue = "Suganya") String name) {
		return "Request Param"+name;
	}
	
	@GetMapping("/request/params")
	public String getRequestParams(@RequestParam List<String> id) {
		return "Request Params"+id; 
	}
	
	@GetMapping("/headers")
	public ResponseEntity<String> getRequestParam(@RequestHeader HttpHeaders header){
		if(isHeaderMissing(header,"name")) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		HttpHeaders responseHeader= new HttpHeaders();
		responseHeader.setExpires(ZonedDateTime.now().plusDays(1));
		String response="Valid Header";
		return ResponseEntity.ok().headers(responseHeader).body(response);
	}
	
	private boolean isHeaderMissing(final HttpHeaders header,final String headerKey) {
		if(!header.containsKey(headerKey)) {
			return true;
		}else {
			return false;
		}
	}
	

}
