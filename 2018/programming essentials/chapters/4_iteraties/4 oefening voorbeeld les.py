# lees rij getallen 9999 om te eindigen
# bereken het gemiddelde
#bereken het kleinste
#bereken het percentage negatieve getallen
teller = 0
teller_negatief = 0
som = 0
getal = int(input("Geef een getal in: "))
kleinste = getal
while getal != 9999:
    som += getal
    teller += 1
    if getal < kleinste:
        kleinste = getal
    if getal < 0:
        teller_negatief += 1
    getal = int(input("Geef een getal in: "))
gemiddelde = som / teller
print("Het gemiddelde is", gemiddelde)
print("Het kleinste getal is:", kleinste)
percentage = teller_negatief / getal * 100
print("Het percentage negatieve getallen is", percentage)