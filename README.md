## entity-validation
Exploring entity validation; answering several issues.

Starting from with boot 2.3, we need to explicitly add the spring-boot-starter-validation dependency.

### @Validated vs @Valid
@Validated: Spring annotation
@Valid: Java annotation

Both can be applied on the class, method, and method argument levels. 

What difference? 

### Catch a constrain violation exception
When putting @Valid on the class and method level,
Hibernate exceptions are caught and wrapped in a Spring exception. 

ConstrainViolationExeption is wrapped in RollBackExpetion, which is wrapped in Spring TransactionSystemException.
How to catch the specific constrain violation exception.

When putting @Valid before method argument parameter, Spring boot throws a MethodArgumentNotValidException.

### Json deseriablize TimeStamp in a correct format. 

Java Date especially timeStamp is not serialized correctly by JSON. 
