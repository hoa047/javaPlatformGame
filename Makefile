all: clean compile run

clean:
	rm -f src/platform/*.class
	rm -f src/platformGame/*.class
	rm -f src/platformGameUtils/*.class
	rm -f src/point/*.class
.PHONY: clean

compile:
	javac src/platformGame/Main.java
.PHONY: compile

run:
	java src.platformGame.Main
.PHONY: run

run-log:
	java src.platformGame.Main log
.PHONY: run

test:
	rm -f test/*.class
	javac -cp .:./jar/* test/*.java
	java -cp .:./jar/* org.junit.runner.JUnitCore test.TestPlatformGame
.PHONY: test
