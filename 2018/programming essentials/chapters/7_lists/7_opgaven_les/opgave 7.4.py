list = []
som = 0
for i in range(10):
    getal = int(input("Geef een getal in: "))
    list.append(getal)
    som += getal
gemiddelde = som / 10
teller = 0
for getal in list: #niet 'if' maar 'for'
    if getal < gemiddelde:
        teller += 1
print("Het aantal getallen kleiner dan het"
      " gemiddelde", teller)
