package kygo.project.products.product_management;

import kygo.project.products.product_management.classes.Mediator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MediatorConfiguration {

    @Bean
    public Mediator mediator() {
        Mediator mediator = new Mediator();
        mediator.registerHandler(CreateProductCommand.class, new CreateProductCommandHandler());
        mediator.registerHandler(GetProductQuery.class, new GetProductQueryHandler());
        return mediator;
    }
}

