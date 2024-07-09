# CNPJ Alfanumérico

Java code for CNPJ Alphanumeric validation

Some design choices that might not be so clear:

I focused on:
 - Avoid unnecessary object creation;
 - Minimize mutability;
 - Reduce the time and space complexity.

## Why not use regex?
Regex and Patterns in Java have a very low performance.
Some methods in String class use a Pattern instances.
These methods are not suitable for repeated use in performance-critical situations.
The problem is that it internally creates a Pattern instance for the regular expression and uses it only once, after which it becomes eligible for garbage collection.
Creating a Pattern instance is expensive because it requires compiling the regular expression into a finite state machine.

## Why not use for-loops to compute the validation digits?
It is better to avoid mutation if you can.
And for-loops increase the complexity of an algorithm.
The logic is straight forward.

## Why not use Streams?
This algorithm uses arrays of primitive types (char and int) and Streams for chars need a wrapper class for each item.
Streams (and a Functional Style of programming) are great, but there are some classes and methods that are only available in newer versions of Java.
You can use this code even in Java 1.5 (legacy systems).

THE BEER-WARE LICENSE Revision 42
 - https://en.wikipedia.org/wiki/Beerware
 - https://fedoraproject.org/wiki/Licensing/Beerware
 - https://people.freebsd.org/~phk/