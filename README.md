# docker compose
go to /src/deploy/docker and do "./stack up" or "./stack up -native"

# run jvm multi image
docker run --pull always --name fhir-facade --rm -p50700:50700 goafabric/fhir-facade:$(grep '^version=' gradle.properties | cut -d'=' -f2)

# run native image
docker run --pull always --name callee-service-native --rm -p50700:50700 goafabric/fhir-facade-native:$(grep '^version=' gradle.properties | cut -d'=' -f2) -Xmx32m

# run native image arm
docker run --pull always --name callee-service-native --rm -p50700:50700 goafabric/fhir-facade-native-arm64v8:$(grep '^version=' gradle.properties | cut -d'=' -f2) -Xmx32m
