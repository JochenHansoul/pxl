#!/bin/bash --

# Opgave
# Schrijf een script oef4.sh dat alle directories die in de
# PATH variabele zitten afdrukt onder elkaar.
# Overzicht directories in PATH
# /usr/local/sbin
# /usr/local/bin
# ...
# Tip: IFS gebruiken !

# Opdracht
IFS=":"
for vDir in $PATH
do
    echo $vDir
    echo "hi"
done
