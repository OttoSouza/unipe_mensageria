package animes.animescon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class AnimesconApplication {
	public static void main(String[] args) {
		SpringApplication.run(AnimesconApplication.class, args);
	}
}
