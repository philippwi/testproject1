# Test Db

## Configuration

Start jboss-cli and enter the following commands:

### MySQL Driver
```
/subsystem=datasources/jdbc-driver=mysql/:add( \
  driver-module-name=com.mysql, \
  driver-name=mysql, \
  driver-class-name=com.mysql.jdbc.Driver, \
  xa-datasource-class=com.mysql.jdbc.jdbc2.optional.MysqlXADataSource)
```

### Data Source
```
/subsystem=datasources/data-source=dataDS/:add( \
  jndi-name=java:jboss/datasources/dataDS, \
  connection-url=jdbc:mysql://localhost:3306/data, \
  driver-name=mysql, \
  driver-class=com.mysql.jdbc.Driver, \
  enabled=true, \
  jta=true, \
  use-java-context=true, \
  user-name="testuser", \
  password="test", \
)
```

### Security Subsystem
```
./subsystem=security/security-domain=dataDomain/:add

./subsystem=security/security-domain=dataDomain/authentication=classic:add( \
  login-modules=[{code=Database, flag=Required, module-options={ \
    dsJndiName="java:jboss/datasources/dataDS", \
    principalsQuery="SELECT password from appuser WHERE loginId=?", \
    rolesQuery="SELECT ar.name, 'Roles' FROM approle ar, appuser_approle auar, appuser au WHERE ar.id = auar.roles_id AND au.id = auar.AppUser_id AND au.loginId = ?", \
    hashAlgorithm=SHA-256, \
    hashEncoding=base64, \
	hashUserPassword=true, \
	hashStorePassword=false, \
}}])
```


## Documentation

### Source Code

* data.beans: beans with a JSF scope
* data.cdi: all other CDI beans
* data.converter: Faces Converter for using POJOs in JSF. Base class is EntityConverter.
* data.db: Data Access Objects (DAO) derived from BaseDao. Tools.java contains some helper methods like loadFully to ensure that all attributes of an object are loaded (see FetchType LAZY).
* data.ejb.aspects: Interceptor examples for EJB beans. SecurityInterceptor tries to implement EBJ-like security concepts for CDI beans.
* data.ejb.beans: Enterprise Java Beans (EJBs)
* data.events: Event objects used for CDI events.
* data.model: JPA Database entities.
* data.scopes: Beans with different JSF scopes for scope demo.
* data.services: REST and SOAP service beans.
* data.services.model: REST/SOAP transport model.
* data.servlet: Demo Servlets and servlets for image access.
* data.websocket: Websocket example.
