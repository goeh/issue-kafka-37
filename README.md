# Sample application

The difference seems to be Micrometer **tags**. The existing meter have the following name and tags:
```
MeterId{name='kafka.consumer.outgoing-byte-total', tags=[tag(client-id=kafka37-test-listener)]}
```
While the new meter has an extra tag:
```
MeterId{name='kafka.consumer.outgoing-byte-total', tags=[tag(client-id=kafka37-test-listener),tag(node-id=node--1)]}
```
This situation causes an exception here https://github.com/micrometer-metrics/micrometer/blob/master/implementations/micrometer-registry-prometheus/src/main/java/io/micrometer/prometheus/PrometheusMeterRegistry.java#L379
