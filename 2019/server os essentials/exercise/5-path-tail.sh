#!/bin/bash --

# Opgave
# Schrijf een script oef5.sh. Pas de vorige oefening aan,
# zodat per directory de laatste 5 entries (in deze directory)
# worden afgedrukt.

# Opdracht
IFS=":"
echo "Overzicht directories in PATH"
for vDir in $PATH
do
    echo "Directory: $vDir"
    ls $vDir | tail -n 5
    echo ""
done
