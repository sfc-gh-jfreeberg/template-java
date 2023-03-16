
!variables;

CREATE STAGE IF NOT EXISTS artifacts;

PUT file://&artifact_name @artifacts AUTO_COMPRESS=FALSE OVERWRITE=TRUE;

CREATE OR REPLACE PROCEDURE MYPROC(msg STRING)
  RETURNS STRING
  LANGUAGE JAVA
  RUNTIME_VERSION = '11'
  IMPORTS = ('@artifacts/&artifact_name')
  HANDLER = 'org.example.procedure.App.run';

CREATE OR REPLACE FUNCTION COMBINE(a STRING, b STRING)
  RETURNS STRING
  LANGUAGE JAVA
  RUNTIME_VERSION = '11'
  IMPORTS = ('@artifacts/&artifact_name')
  HANDLER = 'org.example.udf.Function.combineStrings';
