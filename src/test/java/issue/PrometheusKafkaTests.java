package issue;

import io.micronaut.configuration.kafka.config.AbstractKafkaConfiguration;
import io.micronaut.context.annotation.Property;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@MicronautTest
@Property(name = "kafka.bootstrap.servers", value = "localhost:${random.port}")
@Property(name = AbstractKafkaConfiguration.EMBEDDED, value = "true")
@Property(name = AbstractKafkaConfiguration.EMBEDDED_TOPICS, value = "test")
public class PrometheusKafkaTests {

    @Inject
    @Client("/")
    RxHttpClient httpClient;

    @Test
    public void testSomething() throws Exception {
        HttpResponse<String> response = httpClient.toBlocking().exchange("/prometheus", String.class);
        assertNotNull(response);
        String body = response.body();
        assertNotNull(body);
        System.out.println(body);
    }
}
