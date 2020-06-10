# A Makefile for a project this small is basically oversight but I like it
.PHONY: clean

default: classes

classes: Utilities.java Main.java
	javac Utilities.java
	javac Main.java

brain: classes
	java Main txt/brain.txt

seuss: classes
	java Main txt/seuss.txt

test: classes
	java Main

clean:
	rm *.class
