# demo-camel-with-prometheus

plan:

1 spring boot with camel

2 2 routes, rest api and timer

3 camel jmx enabled by default, add actuator and jolokia to access through rest

4 prometheus jmx exporter

Run a springboot app with jmx port specified:
-Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=8999 -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false -Djava.rmi.server.hostname=localhost

Debug jmx-exporter:
java -Djava.util.logging.config.file=logging.properties -cp collector/target/collector-0.12.3-SNAPSHOT.jar  io.prometheus.jmx.JmxScraper  service:jmx:rmi://localhost:8999/jndi/rmi://localhost:8999/jmxrmi

Run springboot app with jmx-exporter as agent:
-Dorg.apache.camel.jmx.loadStatisticsEnabled=true -javaagent:/Users/jackychen/src/jmx_exporter/jmx_prometheus_javaagent/target/jmx_prometheus_javaagent-0.12.3-SNAPSHOT.jar=localhost:9191:/Users/jackychen/src/demo-camel-with-prometheus/config.yaml
