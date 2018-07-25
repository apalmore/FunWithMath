#!/bin/bash
javac com/austinpalmore/fun_with_math/Main.java -d bin/
cd bin
jar cfm ../FunWithMath.jar Manifest.txt com/austinpalmore/fun_with_math/*
cd ..
rm -rf primes.txt complex.txt bin/com/*
