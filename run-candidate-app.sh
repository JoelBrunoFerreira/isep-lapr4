#!/usr/bin/env bash

# set the class path,
# assumes the build was executed with maven copy-dependencies
export CANDIDATE_APP=jobs4u.app.candidate.console/target/jobs4u.app.candidate.console-0.1.0.jar:jobs4u.app.candidate.console/target/dependency/*

java -cp $CANDIDATE_APP candidate.Jobs4uCandidateApp
