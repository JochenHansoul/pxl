"""Schrijf code die een hoeveelheid centen (opgeslagen in een variabele met de naam bedrag) classificeert als een combinatie van grotere geldstukken. Je code gebruikt 2 euro's (200 centen), euro's (100 centen), 50 centen, 20 centen, 10 centen, 5 centen, 2 centen en centen (1 cent). Het resultaat is dat je het bedrag uitdrukt in het minimale aantal muntjes dat nodig is.
Voorbeeld: 359 centen = 1 x 2 euro, 1 x 1 euro, 1 x 50 cent, 0 x 20 cent, 0 x 10 cent, 1 x 5 cent, 2 x 2 cent en 0 x 1 cent."""

#Bij zulke berekeningen opletten met uitkomsten van 1, 10, 100, ... met delingen waarin 2 en 5, en 20 en 50, ... in voorkomen!!

bedrag = int(input("Geef het bedrag in centen in: "))

print(bedrag // 200, "x 2 euro,", bedrag % 200 // 100, "x 1 euro,", bedrag % 100 // 50, "x 50 cent,", bedrag % 50 // 20, "x 20 cent,", bedrag % 50 % 20 // 10, "x 10 cent,", bedrag % 10 // 5, "x 5 cent,", bedrag % 5 // 2, "x 2 cent,", bedrag % 5 % 2 // 1, "x 1 cent.")

#in de klas wordt er meer met integers gewerkt.


