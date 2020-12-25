#som van reeks getallen reeks eindigt met ingave 0
getal = int(input("geef een getal in "))
som = 0
while getal != 0:
    som += getal
    getal = int(input("Geef een getal in "))
print(som)