package kygo.project.products.product_management.classes;

import kygo.project.products.product_management.models.Product;
import kygo.project.products.product_management.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Retrieval Business Logic.
 * Product Repository is injected in constructor to ensure dependency Injection.
 * CQRS is ensured when the business logic for decoupling both persistence and retrieval are not linked.
 * @see <a href="https://example.com/docs">Official Documentation</a> or {@link #}
 */
public class GetProductQuery {
    private Long productId;
    private final ProductService service;
    private final Product product;


    @Autowired
    public GetProductQuery(ProductService service, Product product) {
        this.product = product;
        this.service = service;
    }

    @Autowired
    public GetProductQuery(Long productId) {
        this.product = service.getProductById(productId);
    }
//    public GetProductQuery (Long id) {
//        this.productId = id;
//    }

    public Long getProductId() {
        return this.productId;
    }

    public void setProductId(Long Id) {
        this.productId = Id;
    }
}
