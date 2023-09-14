package kygo.project.products.product_management.services;

import kygo.project.products.product_management.classes.GetProductQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductQueryHandler {
    private final ProductRepository productRepository;

    @Autowired
    public ProductQueryHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product handle(GetProductQuery query) {
        // Perform query logic
        return productRepository.findById(query.getProductId()).orElse(null);
    }
}
