#!/usr/bin/env bash

# set the class path,
# assumes the build was executed with maven copy-dependencies
export CUSTOMER_APP=jobs4u.app.customer.console/target/jobs4u.app.customer.console-0.1.0.jar:jobs4u.app.customer.console/target/dependency/*

java -cp $CUSTOMER_APP customer.Jobs4uCustomerApp