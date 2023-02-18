# What works
- All simple get Operations with all Objects just work fine for JSON
- Wrapped StringTypes for FHIR are just returned as String (without Extensions)

# What does not work 
- Extensions
- Bundles / Search, as BundleEntry does not contain a List of Objects, but LinkedHashMap, Content is stil there though