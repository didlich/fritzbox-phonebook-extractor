#!/bin/bash

SBT_LAUNCHER_URL="https://repo.typesafe.com/typesafe/ivy-releases/org.scala-sbt/sbt-launch/0.13.9/sbt-launch.jar"

if [ ! -f `dirname $0`/sbt-launch.jar ]
then
    wget ${SBT_LAUNCHER_URL} || \
    curl -O ${SBT_LAUNCHER_URL}  || \
    echo -e "\nSorry neither 'wget' nor curl is found on your system.\nPlease install one of them and try again.\n"
fi

SBT_OPTS="-Xms512M -Xmx1536M -Xss1M -XX:+CMSClassUnloadingEnabled -XX:MaxPermSize=256M"
java $SBT_OPTS -jar `dirname $0`/sbt-launch.jar "$@"


