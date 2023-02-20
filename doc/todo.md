Todos (applies to spring pojo client + server)
- Extension with XML, Extension with JSON works by the hack workaround with add underscore field (e.g. "_family")
- BundleSearch with XML, because this wants geschachtelt XML with inner Resource Type (e.g. "Patient")

Differences to HAPI Fhir
- Need to generate pojos / dtos on your own with Data from HAPI FHIR Facade, e.g with https://www.jsonschema2pojo.org/
- Search Methods need to return manually Bundle
- Produces needs xml, json, fhir+xml, fhir+json
- Metadata Endpoint needs to be implemented for Client to work
- Extensions need special handling