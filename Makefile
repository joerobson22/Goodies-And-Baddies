.PHONY: all exec build buildpackage clean doc

all: exec

exec: build
	java Main

build: buildpackage Main.class Player.class Hitbox.class Colour.class

buildpackage: Ball.class Line.class Rectangle.class Text.class GameArena.class

%.class: %.java
	javac $<

clean:
	rm *.class
	rm -r doc

doc:
	javadoc -d doc *.java
