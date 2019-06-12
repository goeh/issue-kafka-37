package issue;

import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.Topic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Goran Ehrsson
 * @since 1.0
 */
@KafkaListener
@Topic("test")
public class TestListener {

    private static final Logger log = LoggerFactory.getLogger(TestListener.class);

    public void receive(@KafkaKey String key, String message) {
        log.info("Kafka listener received message {}", message);
    }
}
