#!/bin/bash --

# Opgave
# Schrijf een script oef3.sh dat om de seconde aftelt
# van 10 t.e.m. 1 en daarna de tekst “KAPOW” laat
# flikkeren in het rood.
# Laatste lijn in je script moet er als volgt uitzien:
# echo -e "\033[1;31;5;7mKAPOW\033[0m"

# opdracht
for vCounter in {10..1}
do
    echo $vCounter
    sleep 1
done
echo -e "\033[1;31;5;7mKAPOW\033[0m"
