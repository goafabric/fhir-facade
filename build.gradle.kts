import org.springframework.boot.gradle.tasks.bundling.BootBuildImage

group = "org.goafabric"
version = "2.0.5-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

plugins {
	java
	jacoco
	id("org.springframework.boot") version "2.7.10"
	id("io.spring.dependency-management") version "1.1.0"
	id("org.graalvm.buildtools.native") version "0.9.20"
	id("com.google.cloud.tools.jib") version "3.3.1"
}

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
	maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
	constraints {
		implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0")
		implementation("org.mapstruct:mapstruct:1.5.4.Final")
		annotationProcessor("org.mapstruct:mapstruct-processor:1.5.4.Final")
		implementation("io.github.resilience4j:resilience4j-spring-boot3:2.0.2")
	}

	dependencyManagement.imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:2021.0.4")
	}
}

val hapiFhirVersion = "6.4.3"

dependencies {
	//web
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-jersey")

	//monitoring
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("io.micrometer:micrometer-registry-prometheus")

	implementation("org.springframework.cloud:spring-cloud-starter-sleuth")
	implementation("org.springframework.cloud:spring-cloud-sleuth-zipkin")

	//crosscuting
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-aop")
	implementation("org.springframework.cloud:spring-cloud-starter-circuitbreaker-resilience4j")

	//hapi
	implementation("ca.uhn.hapi.fhir:hapi-fhir-jaxrsserver-base:${hapiFhirVersion}")
	implementation("ca.uhn.hapi.fhir:hapi-fhir-server-openapi:${hapiFhirVersion}")

	//code generation
	testAnnotationProcessor("org.projectlombok:lombok")
	testImplementation("org.projectlombok:lombok")

	//test
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("ca.uhn.hapi.fhir:hapi-fhir-client-okhttp:${hapiFhirVersion}")
}

tasks.withType<Test> {
	useJUnitPlatform()
	exclude("**/*NRIT*")
	finalizedBy("jacocoTestReport")
}

val dockerRegistry = "goafabric"
val baseImage = "ibm-semeru-runtimes:open-17.0.6_10-jre-focal@sha256:739eab970ff538cf22a20b768d7755dad80922a89b73b2fddd80dd79f9b880a1"

jib {
	val amd64 = com.google.cloud.tools.jib.gradle.PlatformParameters(); amd64.os = "linux"; amd64.architecture = "amd64"
	val arm64 = com.google.cloud.tools.jib.gradle.PlatformParameters(); arm64.os = "linux"; arm64.architecture = "arm64"
	from.image = baseImage
	to.image = "${dockerRegistry}/${project.name}:${project.version}"
	container.jvmFlags = listOf("-Xms256m", "-Xmx256m")
	from.platforms.set(listOf(amd64, arm64))
}
