- client + tests einbauen
- builder für patient

- builder für search
                   
#spring native error
Caused by: ca.uhn.fhir.context.ConfigurationException: Query parameter type ca.uhn.fhir.rest.param.StringParam has no constructor with types []
at ca.uhn.fhir.rest.param.binder.BaseBinder.<init>(BaseBinder.java:54)
at ca.uhn.fhir.rest.param.binder.QueryParameterTypeBinder.<init>(QueryParameterTypeBinder.java:39)
at ca.uhn.fhir.rest.server.method.SearchParameter.setType(SearchParameter.java:263)
at ca.uhn.fhir.rest.server.method.MethodUtil.getResourceParameters(MethodUtil.java:157)