## entity-validation
Exploring entity validation; answering several issues.

Starting from with boot 2.3, we need to explicitly add the spring-boot-starter-validation dependency.

### @Validated vs @Valid
@Validated: Spring annotation

@Valid: Java annotation


### Catch a constrain violation exception

Hibernate exceptions are caught and wrapped in a Spring exception. 

### Json deseriablize TimeStamp in a correct format. 

Java Date especially timeStamp is not serialized correctly by JSON. 
