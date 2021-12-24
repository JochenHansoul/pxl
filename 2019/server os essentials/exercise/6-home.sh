#!/bin/bash --

# Writer: Jochen Hansoul
# Created: 2021-009-01

vHome=$(ls -A $HOME)

for vDir in $vHome
do
    echo $vDir
    #ls --format=single-column $HOME/$vDir
    #echo ""

    # new try
    #IFS=" "
    for vFile in $(ls $HOME/$vDir)
    do
        echo "    " $vFile
    done
    echo ""
done
