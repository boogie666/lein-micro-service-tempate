#!/bin/bash

echo 'Starting build...'

lein uberjar

echo 'Copying stuff around...'

mkdir {{ns-name}}
mkdir {{ns-name}}/resources


cp target/uberjar/{{ns-name}}.jar {{ns-name}}/

cp scripts/start.sh {{ns-name}}/
cp scripts/stop.sh {{ns-name}}/

cp -R resources/* {{ns-name}}/resources/

echo 'Ziping files...'

tar -zcvf {{ns-name}}.tar.gz {{ns-name}}/

rm -r {{ns-name}}


echo 'All done.'
