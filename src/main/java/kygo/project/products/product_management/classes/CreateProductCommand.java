package kygo.project.products.product_management.classes;

import kygo.project.products.product_management.models.Product;

public class CreateProductCommand {
    private final Product product;
    public CreateProductCommand(Product request) {
        this.product = request ;
    }
}
