#!/bin/bash
#FNAME=../backup$(date | sed -e 's/ /_/g').zip
#zip -r $FNAME *.sh com/* bin/Manifest.txt *.jar test/*
javac com/austinpalmore/fun_with_math/Main.java -d bin/
cd bin
jar cfm ../FunWithMath.jar Manifest.txt com/austinpalmore/fun_with_math/*
cd ..
rm -rf bin/com/ primes.txt complex.txt
chmod +x FunWithMath.jar
