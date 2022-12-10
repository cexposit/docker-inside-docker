#!/bin/bash

# Image name
image="cexposit/prueba"

# Get timestap for the tag
timestamp=$(date +%Y%m%d%H%M%S)

tag=$image:$timestamp
latest=$image:latest

# Build image
mvn clean -Pgithub package -DskipTests
sudo docker build -t $tag -t $latest .

# Remove dangling images
sudo docker system prune -f