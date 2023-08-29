package in.laxmi.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import in.laxmi.feign.GreetFeignClient;

@RestController
public class WelcomeRestController {
	@Autowired
	private GreetFeignClient greetClient;

	@GetMapping("/welcome")
	public String welcomeMsg() {
		/*RestTemplate rt = new RestTemplate();
		ResponseEntity<String> forEntity = rt.getForEntity("http://localhost:8081/greet", String.class);
		String response = forEntity.getBody();*/
		
		String response = greetClient.invokeGreetApi();
		return response + " , welcome to MicroServices";
	}
}
