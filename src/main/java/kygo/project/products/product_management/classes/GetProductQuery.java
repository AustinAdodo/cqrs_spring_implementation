package kygo.project.products.product_management.classes;

import kygo.project.products.product_management.models.Product;
import kygo.project.products.product_management.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Retrieval Business Logic.
 * class not marked as bean because ..........
 * CQRS is ensured when the business logic for decoupling both persistence and retrieval are not linked.
 *
 * @see <a href="https://example.com/docs">Official Documentation</a> or {@link #}
 */
public class GetProductQuery {
    private Long productId;

    public GetProductQuery(Long productId) {
        this.productId = productId;
    }

    public Long getProductId() {
        return this.productId;
    }

    public void setProductId(Long Id) {
        this.productId = Id;
    }
}
