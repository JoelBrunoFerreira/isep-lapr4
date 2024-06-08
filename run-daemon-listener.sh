#!/usr/bin/env bash

export DAEMON_APP=jobs4u.followUp.server/target/jobs4u.followUp.server-0.1.0.jar:jobs4u.followUp.server/target/dependency/*

java -cp $DAEMON_APP daemon.SrvListener