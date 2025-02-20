.PHONY: all exec build buildpackage clean doc

all: exec

exec: build
	java Main

build: buildpackage Main.java Player.java Hitbox.java

buildpackage: Ball.java Line.java Rectangle.java Text.java GameArena.java

%.java:
	javac $@

clean:
	rm *.class
	rm -r doc

doc:
	javadoc -d doc *.java
