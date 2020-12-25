#bereken de gemiddelde leeftijd van 28 studenten.
leeftijd_som = 0
for i in range(28):
    leeftijd = int(input("Geef de leeftijd in "))
    leeftijd_som += leeftijd
gemiddelde = leeftijd_som / 28
print("De gemiddelde leeftijd is:", gemiddelde, "jaar.")