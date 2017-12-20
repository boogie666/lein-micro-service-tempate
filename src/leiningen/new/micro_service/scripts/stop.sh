#!/bin/bash

echo "Stopping {{ns-name}}.jar"
sudo jsvc -java-home "$JAVA_HOME" \
	   -cp "$(pwd)/target/{{ns-name}}.jar" \
	   -pidfile "$(pwd)/pid" \
	   -stop \
	   {{sanitized}}.daemon

echo "Stop successfull."
