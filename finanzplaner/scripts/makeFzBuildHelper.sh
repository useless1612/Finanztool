#!/usr/bin/env sh
JAR_PATH=$(pwd)/.bin/fz.jar
printf '#!/usr/bin/env sh\n'"java -jar ${JAR_PATH} "'$@' > .bin/fz