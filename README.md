# docker compose
go to /src/deploy/docker and do "./stack up" or "./stack up -native"

# run jvm multi image
docker run --pull always --name fhir-facade --rm -p50700:50700 goafabric/fhir-facade:3.2.4-SNAPSHOT

# loki logger
docker run --pull always --name fhir-facade --rm -p50700:50700 --log-driver=loki --log-opt loki-url="http://host.docker.internal:3100/loki/api/v1/push" goafabric/fhir-facade:3.2.4-SNAPSHOT



