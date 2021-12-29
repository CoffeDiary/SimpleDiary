#!/bin/bash

mysql.server start
gradle wrapper
./gradlew --debug build
./gradlew bootRun
