package kygo.project.products.product_management.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

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
