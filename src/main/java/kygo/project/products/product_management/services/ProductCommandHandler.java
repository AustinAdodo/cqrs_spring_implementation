package kygo.project.products.product_management.services;

import kygo.project.products.product_management.classes.CreateProductCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCommandHandler {
    private final ProductRepository productRepository;

    @Autowired
    public ProductCommandHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void handle(CreateProductCommand command) {
        // Validate input and perform business logic
        Product product = new Product(command.getName(), command.getPrice());

        // Save the product to the database
        productRepository.save(product);

        // Publish events if needed
    }
}

