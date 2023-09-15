package kygo.project.products.product_management.classes;

import java.util.Map;

/**
 * I am adding this mediator class to mimic the mediator in c#, benchmarks will be executed against conventional
 * CQRS implementations.
 * @see <a href="https://example.com/docs">Official Documentation</a> or {@link #}
 */
public class Mediator {
    private final Map<Class<?>, Object> handlers = new HashMap<>();

    public void registerHandler(Class<?> messageType, Object handler) {
        handlers.put(messageType, handler);
    }

    public <T> T send(Object message) {
        Object handler = handlers.get(message.getClass());
        if (handler == null) {
            throw new UnsupportedOperationException("No handler registered for " + message.getClass());
        }

        // Execute the handler logic
        // You may need to cast and handle various message types

        return (T) handler;
    }
}
