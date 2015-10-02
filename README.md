# Info

This program will extract your phonebook data from the fritzBox export file.
This small piece of software will perform the steps described in:

http://blog.netplanet.org/2009/02/01/telefonbuch-aus-der-fritzbox-exportieren/

or

https://tino.cc/2013/01/03/fritzbox-telefonbuch-aus-export-extrahieren/

automatically.

# Build and execute

start sbt-launcher download by

    ./sbt.sh
    
run the programm with input file and output directory parameters

    run -i /path/to/fritzbox.export -o /path/to/xml/file/
    
this will create a **phonebook.xml** file

# JAR

To create a JAR file just run:

    ./sbt.sh

    proguard:proguard

The JAR is created under **target/scala-2.11/proguard**

to start the jar use:

    java -jar target/scala-2.11/proguard/fritzbox-phonebook-extractor_2.11-1.0.jar
