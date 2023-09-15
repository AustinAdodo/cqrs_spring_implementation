package kygo.project.products.product_management;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


/**
 * NB: Ensure that your Spring Boot application class (the class with @SpringBootApplication annotation) or your
 * Spring application configuration class scans the package containing your ProductRepository, ProductService,
 * and other Spring components. You can do this by using the @ComponentScan annotation
 * The @EnableJpaRepositories annotation exists to enable Spring Data JPA repositories ensure CQRS
 * @see <a href="https://example.com/docs">Official Documentation</a> or {@link #}
 */
@SpringBootApplication
//@ComponentScan(basePackages = "kygo.project.products.product_management")
@EnableJpaRepositories(basePackages = "kygo.project.products.product_management")
public class ProductManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductManagementApplication.class, args);
    }

}

