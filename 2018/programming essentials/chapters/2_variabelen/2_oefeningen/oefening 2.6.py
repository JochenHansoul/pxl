"""Schrijf code die de oppervlakte van een cirkel berekent, gebruik makend van variabelen straal en pi = 3.14159.
Voor het geval je het vergeten bent, de formule is straal×straal×π.
Toon de uitkomst als volgt: “De oppervlakte van een cirkel met straal ... is ...”.
extra: afgekapt op 2 decimalen"""

phi = 3.14159
#pi wordt als constante gedifineerd: PI
straal = float(input("Geef de straal van de circel in: "))
print("De oppervlakte van een cirkel met straal", straal, "is", int(phi * straal ** 2 * 100) / 100, ".")
