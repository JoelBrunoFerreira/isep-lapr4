#!/usr/bin/env bash

# set the class path,
# assumes the build was executed with maven copy-dependencies
export BACKOFFICE_APP=jobs4u.app.backoffice.console/target/jobs4u.app.backoffice.console-0.1.0.jar:jobs4u.app.backoffice.console/target/dependency/*

java -cp $BACKOFFICE_APP backoffice.Jobs4uBackofficeApp