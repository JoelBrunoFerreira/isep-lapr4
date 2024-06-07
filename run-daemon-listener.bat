REM set the class path,
REM assumes the build was executed with maven copy-dependencies
SET DAEMON_APP=jobs4u.followUp.server\target\jobs4u.followUp.server-0.1.0.jar;jobs4u.followUp.server\target\dependency\*;

REM call the java VM, e.g,
java -cp %DAEMON_APP% daemon.SrvListener