package kygo.project.products.product_management.controllers;

import kygo.project.products.product_management.classes.CreateProductCommand;
import kygo.project.products.product_management.classes.GetProductQuery;
import kygo.project.products.product_management.models.Product;
import kygo.project.products.product_management.services.ProductCommandHandler;
import kygo.project.products.product_management.services.ProductQueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Note: Spring's dependency injection container will manage the lifecycle of the ProductService and automatically
 * inject the ProductRepository into it.
 * @see <a href="https://example.com/docs">Official Documentation</a> or {@link #}
 */
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductCommandHandler commandHandler;
    private final ProductQueryHandler queryHandler;

    @Autowired
    public ProductController(ProductCommandHandler commandHandler, ProductQueryHandler queryHandler) {
        this.commandHandler = commandHandler;
        this.queryHandler = queryHandler;
    }

    @PostMapping
    public ResponseEntity<Void> createProduct(@RequestBody CreateProductCommand command) {
        commandHandler.handle(command);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Long productId) {
        GetProductQuery query = new GetProductQuery();
        query.setProductId(productId);
        Product product = queryHandler.handle(query);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
