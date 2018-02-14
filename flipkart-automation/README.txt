To Run Features in this project, Run the Below Maven command in command prompt.

mvn clean install -DTEST_ENV=dv -DTEST_PLATFORM=WIN -DTEST_BROWSER=chrome -Dcucumber.options="--tags @TAGS" -P cucumber

Valid value for ENVTS:
-DTEST_ENV=dv/ts

Valid value for PLATFORM
-DTEST_PLATFORM=WIN/LINUX

Valid value for Browsers:
-DTEST_BROWSER=chrome/Firefox/ie/phantomjs 