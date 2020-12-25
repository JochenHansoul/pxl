list_getallen = []
som = 0
for i in range(15):
    list_getallen.append(int(input("Geef een getal in: ")))
    som += list_getallen[i]
gemiddelde = som / 15
teller = 0
for i in range(len(list_getallen)):
    if list_getallen[i] < gemiddelde:
        teller += 1
print("Het gemiddelde is {:.1f}, er zijn {} getallen kleiner {:.1f}%".format(gemiddelde, teller, teller/15))