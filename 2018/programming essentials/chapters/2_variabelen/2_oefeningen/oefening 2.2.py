"""
Algoritme
invoer aantal volwassenen
invoer aantal kinderen
prijs aantal vol
* 11 + aantal kind
* 6
"""

#In klas gemaakt
aantal_volwassenen = int(input("Geef het aantal volwassenen in "))
aantal_kind = int(input("Geef het aantal kinderen in "))
prijs = aantal_volwassenen * 11 + aantal_kind * 6
print(prijs)



#zelf gemaakt
var_kind = int(input("aantal kinderen onder de 13 jaar: "))
var_volwassen = int(input("aantal personen boven de 12 jaar: "))

geld_kind = var_kind * 6
geld_volwassenen = var_volwassen * 11

totaal_tarief = geld_kind + geld_volwassenen

print("De totale prijs is", totaal_tarief, "€.")