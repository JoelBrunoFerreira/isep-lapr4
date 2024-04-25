REM set the class path,
REM assumes the build was executed with maven copy-dependencies
SET CUSTOMER_APP=jobs4u.app.customer.console\target\jobs4u.app.customer.console-0.1.0.jar;jobs4u.app.customer.console\target\dependency\*;

REM call the java VM, e.g,
java -cp %CUSTOMER_APP% customer.Jobs4uCustomerApp
