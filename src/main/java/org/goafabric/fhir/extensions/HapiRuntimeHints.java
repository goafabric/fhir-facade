package org.goafabric.fhir.extensions;

import org.goafabric.fhir.controller.BundleController;
import org.goafabric.fhir.controller.OrganizationController;
import org.goafabric.fhir.controller.PatientController;
import org.goafabric.fhir.controller.PractitionerController;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class HapiRuntimeHints implements RuntimeHintsRegistrar{
    @Override
    public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
        registerReflection(hints, "org.hl7.fhir.r4.model");

        hints.resources().registerPattern("ca/uhn/fhir/i18n/hapi-messages.properties");
        hints.resources().registerPattern("org/hl7/fhir/r4/hapi/model/fhirversion.properties");

        registerReflection(hints, org.hl7.fhir.r4.hapi.ctx.FhirR4.class, org.hl7.fhir.r4.hapi.ctx.FhirServerR4.class);
        registerReflection(hints, ca.uhn.fhir.rest.server.PageProvider.class, ca.uhn.fhir.rest.server.provider.ServerCapabilityStatementProvider.class);

        registerReflection(hints, ExceptionHandler.class, HttpInterceptor.class);
        registerReflection(hints, BundleController.class, OrganizationController.class, PatientController.class, PractitionerController.class);
    }

    private static void registerReflection(RuntimeHints hints, String packageName) {
        new Reflections(new ConfigurationBuilder().setUrls(ClasspathHelper.forPackage(packageName))
                .setScanners(new SubTypesScanner(false))
        ).getSubTypesOf(Object.class).stream()
                .filter(clazz -> clazz.getName().startsWith(packageName))
                .forEach(c -> registerReflection(hints, c));
    }

    private static void registerReflection(RuntimeHints hints, Class<?>... types) {
        Arrays.stream(types).forEach(type -> hints.reflection().registerType(type, MemberCategory.DECLARED_CLASSES, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS, MemberCategory.INVOKE_DECLARED_METHODS, MemberCategory.DECLARED_FIELDS));
    }
}
