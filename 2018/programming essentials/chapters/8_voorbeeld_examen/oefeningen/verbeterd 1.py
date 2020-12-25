"""
Het is niet de bedoeling om ze veel mogelijk functies te gebruiken, het is de bedoeling het hoofdprogramma te ontlasten met functies.
Als het hoofdprogramma langer wordt door het gebruik van functies is het niet goed!
als ge meer functies wilt gebruiken:
laagste = min(list_temp
gemiddelde = sum (list_temp) / teller
"""
list_temp = []
list_neerslag = []
som = 0
teller = 0
laagste = 50
veel = False
neerslag = input('Geef regen in: ')
while neerslag != 'overvloed' and teller < 7:
    temperatuur = int(input("Geef de temperatuur in: "))
    list_temp.append(temperatuur)
    list_neerslag.append(neerslag)
    # volgende is goed maar kan efficiënter --> min.list_temp
    if temperatuur < laagste:
        laagste = temperatuur
    som += temperatuur
    if neerslag == "veel":
        veel = True
    #deze altijd op het einde
    teller += 1
    neerslag = input('Geef regen in: ')
print("dag \t temperatuur \t neerslag")
for i in range(len(list_neerslag)):
    print(i + 1, list_temp[i], list_neerslag[i])
if neerslag == "overvloed":
    print("we blijven thuis")
else:
    gemiddelde = som / teller
    if not veel and laagste >= 15 and laagste > 0.2 * gemiddelde:
        print("We gaan op 2 daagse")
    else:
        print("We gaan op daguitstap")