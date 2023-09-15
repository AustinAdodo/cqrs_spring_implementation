package kygo.project.products.product_management.services;

import kygo.project.products.product_management.classes.Mediator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * ScheduledProductUpdater
 * The @EnableJpaRepositories annotation exists to enable Spring Data JPA repositories ensure CQRS
 * @see <a href="https://example.com/docs">Official Documentation</a> or {@link #}
 */
@Service
public class Persistence_Scheduler {
        private final Mediator mediator;
        @Autowired
        public Persistence_Scheduler(Mediator mediator) {
            this.mediator = mediator;
        }

        @Scheduled(fixedRate = 3600000) // Execute every hour
        public void updateProductData() {
            // Send a command or query to update product data
        }
    }
