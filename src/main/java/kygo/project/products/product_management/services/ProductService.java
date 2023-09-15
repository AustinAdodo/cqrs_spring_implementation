package kygo.project.products.product_management.services;

import kygo.project.products.product_management.classes.CreateProductCommand;
import kygo.project.products.product_management.classes.GetProductQuery;
import kygo.project.products.product_management.classes.Mediator;
import kygo.project.products.product_management.models.Product;
import kygo.project.products.product_management.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final Mediator mediator;

    @Autowired
    public ProductService(ProductRepository productRepository,Mediator mediator) {
        this.productRepository = productRepository;
        this.mediator = mediator;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public void createProduct_with_med(Product request) {
        CreateProductCommand createCommand = new CreateProductCommand(request);
        mediator.send(createCommand);
    }

    public Product getProduct_with_med(Long productId) {
        GetProductQuery getProductQuery = new GetProductQuery(productId);
        return mediator.send(getProductQuery);
    }
}

