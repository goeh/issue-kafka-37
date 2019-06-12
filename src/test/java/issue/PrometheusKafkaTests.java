package issue;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
public class PrometheusKafkaTests {

    @Inject
    @Client("/")
    RxHttpClient httpClient;

    @Test
    public void prometheusEndpointShouldReturnMetrics() throws Exception {
        HttpResponse<String> response = httpClient.toBlocking().exchange("/prometheus", String.class);
        assertNotNull(response);
        String body = response.body();
        System.err.println(body);
        assertTrue(body.contains("kafka_consumer"));
    }
}
