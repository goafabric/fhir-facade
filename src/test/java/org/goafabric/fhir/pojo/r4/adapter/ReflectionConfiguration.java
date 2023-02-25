/*
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
public class ReflectionConfiguration {
    static class ApplicationRuntimeHints implements RuntimeHintsRegistrar {
        @Override
        public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
            //pojos
            findClasses("org.goafabric.fhir.pojo.r4.dto").forEach(
                    clazz -> hints.reflection().registerType(clazz, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS, MemberCategory.INVOKE_DECLARED_METHODS));

            findClasses("org.goafabric.fhir.pojo.r4.dto.coverage").forEach(
                    clazz -> hints.reflection().registerType(clazz, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS, MemberCategory.INVOKE_DECLARED_METHODS));

            findClasses("org.goafabric.fhir.pojo.r4.dto.custom").forEach(
                    clazz -> hints.reflection().registerType(clazz, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS, MemberCategory.INVOKE_DECLARED_METHODS));

            findClasses("org.goafabric.fhir.pojo.r4.dto.extension").forEach(
                    clazz -> hints.reflection().registerType(clazz, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS, MemberCategory.INVOKE_DECLARED_METHODS));

            findClasses("org.goafabric.fhir.pojo.r4.dto.metadata").forEach(
                    clazz -> hints.reflection().registerType(clazz, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS, MemberCategory.INVOKE_DECLARED_METHODS));

            findClasses("org.goafabric.fhir.pojo.r4.dto.observation").forEach(
                    clazz -> hints.reflection().registerType(clazz, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS, MemberCategory.INVOKE_DECLARED_METHODS));
        }

        private Stream<Class<?>> findClasses(String packageName) {
            return new BufferedReader(new InputStreamReader(ClassLoader.getSystemClassLoader().getResourceAsStream(packageName.replaceAll("[.]", "/")))).lines()
                    .filter(line -> line.endsWith(".class")).map(clazz -> {
                        try {
                            //System.err.println(Class.forName(packageName + "." + clazz.substring(0, clazz.lastIndexOf('.'))));
                            return Class.forName(packageName + "." + clazz.substring(0, clazz.lastIndexOf('.')));
                        } catch (ClassNotFoundException e) {
                            throw new IllegalStateException(e);
                        }
                    });
        }

    }
}

 */
