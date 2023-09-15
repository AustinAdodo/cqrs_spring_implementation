package kygo.project.products.product_management.repositories;

import kygo.project.products.product_management.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Note: It's a good practice to annotate your repository interface with @Repository
 * @see <a href="https://example.com/docs">Official Documentation</a> or {@link #}
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // You can add custom query methods here if needed
}

