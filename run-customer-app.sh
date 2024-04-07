#!/usr/bin/env bash

# set the class path,
# assumes the build was executed with maven copy-dependencies
export CUSTOMER_APP=jobs4u.app2/target/jobs4u.app2-0.1.0.jar:jobs4u.app2/target/dependency/*

java -cp $CUSTOMER_APP customer.App_Customer