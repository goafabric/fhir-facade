# docker compose
go to /src/deploy/docker and do "./stack up" or "./stack up -native"

# run jvm multi image
docker run --pull always --name fhir-facade --rm -p50700:50700 goafabric/fhir-facade:$(grep '^version=' gradle.properties | cut -d'=' -f2)


