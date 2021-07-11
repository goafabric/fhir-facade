#!/bin/bash
git pull
time mvn clean spring-boot:build-image -P docker-image-native
#time mvn clean spring-boot:build-image install -P docker-image-native
docker run --name fhir-facade-native --rm -p50800:50800 goafabric/fhir-facade-native:1.0.5-native-SNAPSHOT