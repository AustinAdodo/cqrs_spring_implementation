package kygo.project.products.product_management;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

/**
 * The @EnableJpaRepositories annotation exists to enable Spring Data JPA repositories ensure CQRS
 * @see <a href="https://example.com/docs">Official Documentation</a> or {@link #}
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = "kygo.project.products.product_management")
public class ProductManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductManagementApplication.class, args);
    }

}

