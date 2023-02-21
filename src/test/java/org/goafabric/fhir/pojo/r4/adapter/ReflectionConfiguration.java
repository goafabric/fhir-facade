package org.goafabric.fhir.pojo.r4.adapter;

import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportRuntimeHints;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

@Configuration
@ImportRuntimeHints(ReflectionConfiguration.ApplicationRuntimeHints.class)
//@RegisterReflectionForBinding(
//        {Patient.class, Practitioner.class, Organization.class, TIConfigurationPojo.class,
//                Coverage.class, Beneficiary.class, Payor.class, Type.class,
//                Observation.class, Origin.class, Subject.class, ValueSampledData.class,
//                Address.class, Bundle.class, HumanName.class, Identifier.class, Meta.class, Telecom.class, Text.class,
//                Extension.class, ExtensionWrapper.class})
public class ReflectionConfiguration {
    static class ApplicationRuntimeHints implements RuntimeHintsRegistrar {
        @Override
        public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
            //pojos
            findClasses("org.goafabric.fhir.controller.dto").forEach(
                    clazz -> hints.reflection().registerType(clazz, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS, MemberCategory.INVOKE_DECLARED_METHODS));

            findClasses("org.goafabric.fhir.controller.dto.coverage").forEach(
                    clazz -> hints.reflection().registerType(clazz, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS, MemberCategory.INVOKE_DECLARED_METHODS));

            findClasses("org.goafabric.fhir.controller.dto.custom").forEach(
                    clazz -> hints.reflection().registerType(clazz, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS, MemberCategory.INVOKE_DECLARED_METHODS));

            findClasses("org.goafabric.fhir.controller.dto.extension").forEach(
                    clazz -> hints.reflection().registerType(clazz, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS, MemberCategory.INVOKE_DECLARED_METHODS));

            findClasses("org.goafabric.fhir.controller.dto.metadata").forEach(
                    clazz -> hints.reflection().registerType(clazz, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS, MemberCategory.INVOKE_DECLARED_METHODS));

            findClasses("org.goafabric.fhir.controller.dto.observation").forEach(
                    clazz -> hints.reflection().registerType(clazz, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS, MemberCategory.INVOKE_DECLARED_METHODS));
        }

        private Stream<Class<?>> findClasses(String packageName) {
            return new BufferedReader(new InputStreamReader(ClassLoader.getSystemClassLoader().getResourceAsStream(packageName.replaceAll("[.]", "/")))).lines()
                    .filter(line -> line.endsWith(".class") && !line.contains("$")).map(clazz -> {
                        try {
                            System.err.println(Class.forName(packageName + "." + clazz.substring(0, clazz.lastIndexOf('.'))));
                            return Class.forName(packageName + "." + clazz.substring(0, clazz.lastIndexOf('.')));
                        } catch (ClassNotFoundException e) {
                            throw new IllegalStateException(e);
                        }
                    });
        }

    }
}

