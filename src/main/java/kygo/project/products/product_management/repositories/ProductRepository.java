package kygo.project.products.product_management.repositories;

import kygo.project.products.product_management.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // You can add custom query methods here if needed
}

