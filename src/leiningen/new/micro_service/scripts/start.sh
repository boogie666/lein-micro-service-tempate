#!/bin/bash

echo "Starting {{ns-name}}"
sudo jsvc -java-home "$JAVA_HOME" \
     -server \
     -Dhttp_port=10556 \
	   -cp "$(pwd)/{{ns-name}}.jar" \
	   -outfile "$(pwd)/stdout.log" \
	   -pidfile "$(pwd)/pid" \
	   -errfile "$(pwd)/{{ns-name}}.log" \
	   {{sanitized}}.daemon

echo "Start successfull"
echo "execute \"sudo cat {{ns-name}}.log\" to see logs"
