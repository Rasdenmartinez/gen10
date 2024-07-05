package ms.ejercicio1_metodosCrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Ejercicio1MetodosCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio1MetodosCrudApplication.class, args);
	}

}
