# docker compose
go to /src/deploy/docker and do "./stack up" or "./stack up -native"

# run jvm multi image
docker run --pull always --name fhir-facade --rm -p50700:50700 goafabric/fhir-facade:3.0.0-MVC-SNAPSHOT

# run native image
docker run --pull always --name fhir-facade-native --rm -p50700:50700 goafabric/fhir-facade-native:3.0.0-MVC-SNAPSHOT -Xmx32m

# run native image arm
docker run --pull always --name fhir-facade-native --rm -p50700:50700 goafabric/fhir-facade-native-arm64v8:3.0.0-MVC-SNAPSHOT -Xmx32m

# loki logger
docker run --pull always --name fhir-facade --rm -p50700:50700 --log-driver=loki --log-opt loki-url="http://host.docker.internal:3100/loki/api/v1/push" goafabric/fhir-facade:3.0.0-MVC-SNAPSHOT