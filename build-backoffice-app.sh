#!/usr/bin/env bash

mvn $1 package dependency:copy-dependencies -pl jobs4u.app.backoffice.console -am