list = [5, 4, 8, -4, -2, 100, 37, 58, 32]

grootste = list[0] # als niets weet over het getal gewoon het eerste nemen
for i in range(len(list)):
    if grootste < list[i]:
        grootste = list[i]
print("Het grootste getal is:", grootste)

kleinste = list[0]
for i in range(len(list)):
    if kleinste > list[i]:
        kleinste = list[i]
print("Het kleinste getal is", kleinste)

# efficienter:
for i in range(len(list)):
    if grootste < list[i]:
        grootste = list[i]
    elif kleinste > list[i]:
        kleinste = list[i]
print("Het grootste getal is:", grootste)
print("Het kleinste getal is", kleinste)

# De som berekenen:
som = 0
for getal in list:
    som += getal
print("De som is", som)

# alternatief: gebruik maken van ingebouwde functies/methodes
print("Het grootste getal is", max(list))
print("Het kleinste getal is", min(list))
print("De som is", sum(list))