#!/bin/bash

# Navigate to the src directory
cd src

# Compile the Java files and place the .class files in the bin directory
javac -d ../bin chess/*.java pieces/*.java ml/*.java

# Navigate back to the root directory
cd ..

echo "Build completed successfully."
