all: compile

compile:
	mvn compile

exec: compile light-exec

light-exec:
	mvn exec:java

clean:
	mvn clean

fat-jar:
	mvn package assembly:single

coverage:
	mvn jacoco:prepare-agent test jacoco:report

install: fat-jar .bin/fz

update-symlink:
	rm .bin/fz.jar
	ln -s ../$(shell ls target/finanzplaner-*-SNAPSHOT-jar-with-dependencies.jar) .bin/fz.jar

.bin/fz:
	-mkdir .bin
	ln -s ../$(shell ls target/finanzplaner-*-SNAPSHOT-jar-with-dependencies.jar) .bin/fz.jar
	sh scripts/makeFzBuildHelper.sh
	chmod +x .bin/fz