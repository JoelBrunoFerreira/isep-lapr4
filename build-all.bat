REM ECHO OFF
REM ECHO make sure JAVA_HOME is set to JDK folder
REM ECHO make sure maven is on the system PATH
mvn %1 dependency:copy-dependencies package -am