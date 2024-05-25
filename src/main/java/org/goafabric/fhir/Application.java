package org.goafabric.fhir;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportRuntimeHints;

@SpringBootApplication
@ImportRuntimeHints(Application.ApplicationRuntimeHints.class)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner init(ApplicationContext context) {
        return args -> {if ((args.length > 0) && ("-check-integrity".equals(args[0]))) {SpringApplication.exit(context, () -> 0);}};
    }

    static class ApplicationRuntimeHints implements RuntimeHintsRegistrar {
        @Override
        public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
            hints.resources().registerPattern("ca/uhn/fhir/i18n/hapi-messages.properties");
            hints.resources().registerPattern("org/hl7/fhir/r4/hapi/model/fhirversion.properties");

            registerReflection(org.hl7.fhir.r4.hapi.ctx.FhirR4.class, hints);
            registerReflection(org.hl7.fhir.r4.hapi.ctx.FhirServerR4.class, hints);
            registerReflection(ca.uhn.fhir.rest.server.provider.ServerCapabilityStatementProvider.class, hints);
            registerReflection(ca.uhn.fhir.rest.server.PageProvider.class, hints);

            registerReflection("org.hl7.fhir.r4.model", hints);

            registerReflection(org.goafabric.fhir.crossfunctional.ExceptionHandler.class, hints);
            registerReflection(org.goafabric.fhir.crossfunctional.HttpInterceptor.class, hints);

            registerReflection(org.goafabric.fhir.controller.BundleController.class, hints);
            registerReflection(org.goafabric.fhir.controller.OrganizationController.class, hints);
            registerReflection(org.goafabric.fhir.controller.PatientController.class, hints);
            registerReflection(org.goafabric.fhir.controller.PractitionerController.class, hints);

            //hints.resources().registerPattern("META-INF/maven/org.webjars/swagger-ui/pom.properties");
            //hints.reflection().registerType(net.sf.saxon.Configuration.class, hints);
        }
    }

    private static void registerReflection(String packageName, RuntimeHints hints) {
        new Reflections(new ConfigurationBuilder().setUrls(ClasspathHelper.forPackage(packageName))
                .setScanners(new SubTypesScanner(false))
        ).getSubTypesOf(Object.class).stream()
                .filter(clazz -> clazz.getName().startsWith(packageName))
                .forEach(c -> {
                    /*
                    if (c.getName().contains("__BeanDefinitions")) { //stupid spring aot hack
                        try {
                            c = Class.forName(c.getName().replace("__BeanDefinitions", ""));
                        } catch (ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    */
                    System.out.println(c);
                    registerReflection(c, hints);
                });
    }

    private static void registerReflection(Class<?> type, RuntimeHints hints) {
        hints.reflection().registerType(type, MemberCategory.DECLARED_CLASSES, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS, MemberCategory.INVOKE_DECLARED_METHODS, MemberCategory.DECLARED_FIELDS);
    }


}