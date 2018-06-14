
#!/bin/bash
FNAME=../backup$(date | sed -e 's/ /_/g').zip
zip -r $FNAME *.sh com/* bin/Manifest.txt bin/com/austinpalmore/fun_with_math/probability/FXMLDocument.fxml *.jar test/*
javac com/austinpalmore/fun_with_math/Main.java com/austinpalmore/fun_with_math/probability/*.java -d bin/ -Xlint
cd bin
jar cfm ../FunWithMath.jar Manifest.txt com/austinpalmore/fun_with_math/* com/austinpalmore/fun_with_math/probability/FXMLDocument.fxml
cd ..
rm -rf primes.txt complex.txt bin/com/austinpalmore/fun_with_math/*.class  bin/com/austinpalmore/fun_with_math/{algorithms,cryptograpy,numbers,probability,util}/*.class
