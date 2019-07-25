package sabillon.springframework5.recipe.app.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The Class TestApplication.
 */
@SpringBootApplication()
@EnableAutoConfiguration()
public class TestApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

}
