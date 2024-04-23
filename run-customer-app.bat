REM set the class path,
REM assumes the build was executed with maven copy-dependencies
SET CUSTOMER_APP=jobs4u.app2\target\jobs4u.app2-0.1.0.jar;jobs4u.app2\target\dependency\*;

REM call the java VM, e.g,
java -cp %CUSTOMER_APP% customer.Jobs4uCustomerApp
