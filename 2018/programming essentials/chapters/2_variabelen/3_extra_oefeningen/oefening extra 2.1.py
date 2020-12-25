"""
Gegeven:
Om de 2 maanden: 20€
telefoongesprek binnenland 0.12€ (geen BTW)
telefoongesprek buitenland: 0.5 € per min. (geen BTW)
BTW 21%

Gevraagd:
Bereken hoeveel je moet betalen voor de afgelopen maand.
"""

#invoer gegevens
maanden1 = int(input("Aantal maanden klant: "))
telefoon_binnenland = int(input("Aantal keer gebeld in het binnenland: "))
telefoon_buitenland = int(input("Aantal minuten gebeld in het buitenland: "))

#berekeningen
#maandelijks tarief
maanden2 = (maanden1 + 1) % 2
maand_tarief = maanden2 * 20
maand_tarief += (maand_tarief * 0.21)

#binnen en buitenland
binnenland_tarief = telefoon_binnenland * 0.12
buitenland_tarief = telefoon_buitenland * 0.5

#volledig tarief
totaal_tarief = maand_tarief + binnenland_tarief + buitenland_tarief

#uitprinten gegevens
print("U moet deze maand", totaal_tarief, "€ betalen.")