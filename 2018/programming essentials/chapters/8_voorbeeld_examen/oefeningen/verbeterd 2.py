"""Ge kunt hier het beste', voor het afprinten, een aantal vorbeelden bij geven
1 - 100
1, 2, ... 100
2
2, 4, 6, ... 100
1, 2, 3, ... 33
3
3, 6, 9 ... 9
1, 2, 3 ... 25
4
4, 8, 12 ... 100
1, 2, 3 ... 25
"""
from random import randint


aantal = int(input("Hoeveel gehele getallen nodig?: "))
while aantal <= 1:
    aantal = int(input("geef een positief geheel getal in groter dan nul: "))
veelvoud_getal = int(input("Geef een veelvoudgetal in: "))
while not veelvoud_getal > 0 and veelvoud_getal < 10: # dit moest uiteraad groter zijn dan 0!
    veelvoud_getal = int(input("Geef een veelvoudgetal kleiner dan 10 in: "))
lijst_getal = []
som = 0
for i in range(aantal):
    grens = 100 // veelvoud_getal
    getal = randint(1, grens) * veelvoud_getal
    som += getal
    lijst_getal.append(getal)
gemiddelde = som / aantal
# afprinten:
print("De genereerde getallen zijn")
for getal in lijst_getal: # print(lijst_getal) --> deze output is niet goed, zie output opgave!
    print(getal, "", end="")
print()
if aantal % 2 != 0:
    print("De array in speciale afdruk")
    for i in range(len(lijst_getal) - 1, -1, -1): # begint bij het laatste getal, gaat van stapjes van -1, stopt bij eerste getal (moet -1 zetten anders stopt bij 2e getal!)
        print(lijst_getal[i], end=" ")
    print()
print("De getallen die kleiner zijn dan het gemiddelde")
for getal in lijst_getal:
    if getal < gemiddelde:
        print(getal, end=" ")
print()