#Gemiddelde leeftijd van 28 studenten met while.
som = 0
teller = 0
while teller <= 28:
    leeftijd = int(input("Geef de leeftijd in "))
    som += leeftijd
    teller += 1
gemiddelde = som / teller
print(gemiddelde)