# What works
- All simple get Operations with all Objects just work fine for JSON
- Wrapped StringTypes for FHIR are just returned as String (without Extensions)
- Search Operations

# What does not work 
- Extensions
- Generic Bundles, will be returned as LinkedHashmap as we are unable to predict the Type upfront 