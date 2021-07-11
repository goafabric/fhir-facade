- Quarkus build
  
  Caused by: org.springframework.boot.web.server.WebServerException: Unable to start embedded Tomcat server
  at org.springframework.boot.web.embedded.tomcat.TomcatWebServer.start(TomcatWebServer.java:229) ~[na:na]
  at org.springframework.boot.web.servlet.context.WebServerStartStopLifecycle.start(WebServerStartStopLifecycle.java:43) ~[na:na]
  at org.springframework.context.support.DefaultLifecycleProcessor.doStart(DefaultLifecycleProcessor.java:178) ~[org.goafabric.example.fhir.Application:5.3.8]
  ... 14 common frames omitted
  Caused by: org.springframework.boot.web.server.WebServerException: Servlet [fhirRestfulServerConfiguration] in web application [] threw load() exception
  at org.springframework.boot.web.embedded.tomcat.TomcatEmbeddedContext.load(TomcatEmbeddedContext.java:87) ~[na:na]
  at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183) ~[na:na]
  at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1655) ~[na:na]
  at java.util.stream.ReferencePipeline$Head.forEach(ReferencePipeline.java:658) ~[na:na]
  at java.util.stream.ReferencePipeline$7$1.accept(ReferencePipeline.java:274) ~[na:na]
  at java.util.TreeMap$ValueSpliterator.forEachRemaining(TreeMap.java:2890) ~[na:na]
  at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:484) ~[na:na]
  at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474) ~[na:na]
  at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150) ~[na:na]
  at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173) ~[na:na]
  at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234) ~[na:na]
  at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497) ~[na:na]
  at org.springframework.boot.web.embedded.tomcat.TomcatEmbeddedContext.lambda$deferredLoadOnStartup$0(TomcatEmbeddedContext.java:65) ~[na:na]
  at org.springframework.boot.web.embedded.tomcat.TomcatEmbeddedContext.doWithThreadContextClassLoader(TomcatEmbeddedContext.java:106) ~[na:na]
  at org.springframework.boot.web.embedded.tomcat.TomcatEmbeddedContext.deferredLoadOnStartup(TomcatEmbeddedContext.java:64) ~[na:na]
  at org.springframework.boot.web.embedded.tomcat.TomcatWebServer.performDeferredLoadOnStartup(TomcatWebServer.java:305) ~[na:na]
  at org.springframework.boot.web.embedded.tomcat.TomcatWebServer.start(TomcatWebServer.java:216) ~[na:na]
  ... 16 common frames omitted
  Caused by: javax.servlet.ServletException: Failed to initialize FHIR Restful server
  at ca.uhn.fhir.rest.server.RestfulServer.init(RestfulServer.java:1333) ~[org.goafabric.example.fhir.Application:na]
  at javax.servlet.GenericServlet.init(GenericServlet.java:158) ~[org.goafabric.example.fhir.Application:4.0.FR]
  at org.apache.catalina.core.StandardWrapper.initServlet(StandardWrapper.java:1143) ~[na:na]
  at org.apache.catalina.core.StandardWrapper.load(StandardWrapper.java:992) ~[na:na]
  at org.springframework.boot.web.embedded.tomcat.TomcatEmbeddedContext.load(TomcatEmbeddedContext.java:82) ~[na:na]
  ... 32 common frames omitted
  Caused by: ca.uhn.fhir.context.ConfigurationException: Did not find any annotated RESTful methods on provider class org.hl7.fhir.r4.hapi.rest.server.ServerCapabilityStatementProvider
  at ca.uhn.fhir.rest.server.RestfulServer.findResourceMethods(RestfulServer.java:418) ~[org.goafabric.example.fhir.Application:na]
  at ca.uhn.fhir.rest.server.RestfulServer.init(RestfulServer.java:1307) ~[org.goafabric.example.fhir.Application:na]
  ... 36 common frames omitted