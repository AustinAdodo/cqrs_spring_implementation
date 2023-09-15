package kygo.project.products.product_management.models;

import jakarta.persistence.*;


/**
 * Primary Product class
 * @see <a href="https://example.com/docs">Official Documentation</a> or {@link #}
 */
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price=price;
    }

    public Product() {

    }
}

