package kygo.project.products.product_management.classes;

/**
 * Retrieval Business Logic.
 * Product Repository is injected in constructor to ensure dependency Injection.
 * CQRS is ensured when the business logic for decoupling both persistence and retrieval are not linked.
 * @see <a href="https://example.com/docs">Official Documentation</a> or {@link #}
 */
public class GetProductQuery {
    private Long productId;

    public Long getProductId() {
        return this.productId;
    }

    public void setProductId(Long Id) {
        this.productId = Id;
    }
}
