#!/bin/bash

./mvnw clean install -DskipTests
docker-compose build
