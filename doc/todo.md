- client + tests einbauen
- builder für patient

- builder für search
                   
#spring native error
Caused by: java.lang.ClassNotFoundException: org.hl7.fhir.dstu3.model.DataRequirement
at com.oracle.svm.core.hub.ClassForNameSupport.forName(ClassForNameSupport.java:60) ~[na:na]
at java.lang.Class.forName(DynamicHub.java:1247) ~[na:na]
at ca.uhn.fhir.context.ModelScanner.scanVersionPropertyFile(ModelScanner.java:519) ~[na:na]
... 99 common frames omitted
