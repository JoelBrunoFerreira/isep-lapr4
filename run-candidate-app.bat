REM set the class path,
REM assumes the build was executed with maven copy-dependencies
SET CANDIDATE_APP=jobs4u.app1\target\jobs4u.app1-0.1.0.jar;jobs4u.app1\target\dependency\*;

REM call the java VM, e.g,
java -cp %CANDIDATE_APP% candidate.App_Candidate
