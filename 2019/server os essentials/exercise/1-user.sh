#!/bin/bash --

# output:
# Ik ben student
# Mijn homedir is /home/student
# Ik heb 70 entries in /home/student

# arithmetic expression:
# $((expression))

# main
echo "Ik ben $USER"
echo "Mijn homedir is $HOME"
echo "Ik heb $(($(ls -la $HOME | wc -l) - 1)) entries in mijn $HOME"
