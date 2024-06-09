#!/usr/bin/env bash
# ECHO OFF
# ECHO make sure JAVA_HOME is set to JDK folder
# ECHO make sure maven is on the system PATH
mvn -B $1 dependency:copy-dependencies package

# Copy plugins JARs
cd jobs4u.app.backoffice.console/target/dependency
cp ../../../plugins/*.jar .
