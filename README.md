# restful_crud_v8
Restful CRUD example for Tomcat 8 (not more)

Example of CRUD using JAX-RS and JPA for Tomcat 8 (not more) and EclipseLink

Database folder for MySQL: Jardineria

Aspects to underline:
- Restful with user + password sent in HTML Header.
- JAX-RS with List: using a wrapping class: LinkedList_envuelta.
- JAX-RS using JSON.
- JPA using transactions.

Comments:
- Libreries are decisives in order to make code working. With wrong libraries, the code does not work. Giving with error messages with very few information, and sometimes, not giving error messages.
- Tomcat v9 is not compatible with v8 and previous, some javax... packetes are not used anymore, replaced by jakarta... packets (no error messages if libraries mix that usage, but does not work)
- Database used: MySQL

Libraries:

- -rwxrwxrwx 1   69409 dic 24 12:08 activation-1.1.1.jar
- -rwxrwxrwx 1  320122 dic 24 12:08 asm-all-repackaged-2.2.0-b21.jar
- -rwxrwxrwx 1  282811 dic 24 12:08 cglib-2.2.0-b21.jar
- -rwxrwxrwx 1 2189117 dic 24 12:08 guava-14.0.1.jar
- -rwxrwxrwx 1  130236 dic 24 12:08 hk2-api-2.2.0-b21.jar
- -rwxrwxrwx 1  147772 dic 24 12:08 hk2-locator-2.2.0-b21.jar
- -rwxrwxrwx 1   66742 dic 24 12:08 hk2-utils-2.2.0-b21.jar
- -rwxrwxrwx 1 1315115 dic 24 12:08 javaee-web-api-7.0.jar
- -rwxrwxrwx 1   26366 dic 24 12:08 javax.annotation-api-1.2.jar
- -rwxrwxrwx 1    5982 dic 24 12:08 javax.inject-2.2.0-b21.jar
- -rwxrwxrwx 1  203426 dic 24 12:08 javax.persistence-2.2.1.jar
- -rwxrwxrwx 1   85353 dic 24 12:08 javax.servlet-api-3.0.1.jar
- -rwxrwxrwx 1  112758 dic 24 12:08 javax.ws.rs-api-2.0.jar
- -rwxrwxrwx 1  100146 dic 24 12:08 jaxb-api-2.2.7.jar
- -rwxrwxrwx 1  159742 dic 24 12:08 jersey-client.jar
- -rwxrwxrwx 1  700399 dic 24 12:08 jersey-common.jar
- -rwxrwxrwx 1   53804 dic 24 12:08 jersey-container-servlet-core.jar
- -rwxrwxrwx 1   15684 dic 24 12:08 jersey-container-servlet.jar
- -rwxrwxrwx 1   63478 dic 24 12:08 jersey-entity-filtering-2.5.1.jar
- -rwxrwxrwx 1   24673 dic 24 12:08 jersey-media-moxy-2.5.1.jar
- -rwxrwxrwx 1  828016 dic 24 12:08 jersey-server.jar
- -rwxrwxrwx 1 2462344 dic 24 12:08 mysql-connector-java-8.0.26.jar
- -rwxrwxrwx 1  147580 dic 24 12:08 org.eclipse.persistence.antlr-2.7.7.jar
- -rwxrwxrwx 1  487709 dic 24 12:08 org.eclipse.persistence.asm-2.7.7.jar
- -rwxrwxrwx 1 5188750 dic 24 12:08 org.eclipse.persistence.core-2.7.7.jar
- -rwxrwxrwx 1 1409185 dic 24 12:08 org.eclipse.persistence.jpa-2.7.7.jar
- -rwxrwxrwx 1 1332996 dic 24 12:08 org.eclipse.persistence.jpa.jpql-2.7.7.jar
- -rwxrwxrwx 1  621183 dic 24 12:08 org.eclipse.persistence.moxy-2.7.7.jar
- -rwxrwxrwx 1  246924 dic 24 12:08 org.osgi.core-4.2.0.jar
- -rwxrwxrwx 1   20235 dic 24 12:08 osgi-resource-locator-1.0.1.jar
- -rwxrwxrwx 1   52150 dic 24 12:08 persistence-api-1.0.jar
- -rwxrwxrwx 1   63777 dic 24 12:08 validation-api-1.1.0.Final.jar
