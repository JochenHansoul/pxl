getala = int(input("Geef getal a in: "))
getalb = int(input("Geef getal b in: "))
if getala <= getalb:
    grootste_getal = getalb
    kleinste_getal = getala
else:
    grootste_getal = getala
    kleinste_getal = getalb
if kleinste_getal == 0:
    deling_getallen = "error"
else:
    deling_getallen = grootste_getal / kleinste_getal
print("Het kleinste getal is:", kleinste_getal, "Het kwadraat van het kleinste getal is:", kleinste_getal **2, "Het grootste getal gedeeld door het kleinste getal is:", deling_getallen)