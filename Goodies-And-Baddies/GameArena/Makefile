.PHONY: all exec build buildpackage clean

all: exec

exec: build
	java Driver

build: buildpackage Main.java Player.java

buildpackage: Ball.java Line.java Rectangle.java Text.java GameArena.java

%.java:
	javac $@

clean:
	rm *.class
