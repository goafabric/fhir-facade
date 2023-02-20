# What works
- Json Representation, not XML
- All simple get Operations with all Objects just work fine for JSON
- Search Operations
- Extensions have to defined as an extra "_" field, see a json example and class HumanName why 

# What does not work
- Generic Bundles, will be returned as LinkedHashmap as we are unable to predict the Type upfront 