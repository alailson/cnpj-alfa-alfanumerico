# CNPJ Alfanumérico

Java code for CNPJ Alphanumeric validation

Some design choices that might not be so clear:

Why don't use regex?
Regexes have low performance in Java.

Why don't use for loops to compute the validation digits?
It is better to avoid mutation and for-loops increase the complexity of an algorithm.
The logic is not dynamic and is straight forward.

THE BEER-WARE LICENSE Revision 42
 - https://en.wikipedia.org/wiki/Beerware
 - https://fedoraproject.org/wiki/Licensing/Beerware
 - https://people.freebsd.org/~phk/