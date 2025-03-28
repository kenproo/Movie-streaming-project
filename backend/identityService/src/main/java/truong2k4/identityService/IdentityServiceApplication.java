package truong2k4.identityService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class IdentityServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(IdentityServiceApplication.class, args);
	}

}
