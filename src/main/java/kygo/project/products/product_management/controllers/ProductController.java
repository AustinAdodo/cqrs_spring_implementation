package kygo.project.products.product_management.controllers;

import kygo.project.products.product_management.classes.CreateProductCommand;
import kygo.project.products.product_management.classes.GetProductQuery;
import kygo.project.products.product_management.classes.Mediator;
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
    private final Mediator mediator;

    @Autowired
    public ProductController(ProductCommandHandler commandHandler, ProductQueryHandler queryHandler, Mediator mediator) {
        this.commandHandler = commandHandler;
        this.queryHandler = queryHandler;
        this.mediator = mediator;
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

    @PostMapping("/create")
    public ResponseEntity<Void> createProduct_with_med(@RequestBody Product request) {
        CreateProductCommand createCommand = new CreateProductCommand(request);
        mediator.send(createCommand);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProduct_with_med(@PathVariable Long productId) {
        GetProductQuery getProductQuery = new GetProductQuery(productId);
        Product product = mediator.send(getProductQuery);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
