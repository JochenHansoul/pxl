from random import randint


def zetOmNaarRomeinsCijfer(getal):
    list_roman = ["XL", "X", "IX", "V", "IV", "I"] # dit hierin plaatsen is niet goed, telkens hij de functie opnieuw doet maakt hij die in wezen opnieuw aan en moet hij steeds deze twee lijsten opnieuw aanmaken
    waarde = [40, 10, 9, 5, 4, 1]
    romeins_getal = ""
    for i in range(6):
        while getal >= waarde[i]:
            romeins_getal += list_roman[i]
            getal -= waarde[i]
    return romeins_getal


letter = ord(input("Geef een letter in: "))
letter_a = ord("a") -1
aantal_reeksen = letter - letter_a
reeksen = []
for i in range(aantal_reeksen):
    reeksen.append([])
    reeksen[i].append(randint(1, 49))
    getal = randint(1, 49)
    kolom = 0
    while getal > reeksen[i][kolom]:
        reeksen[i].append(getal)
        kolom += 1
        getal = randint(1, 49)
# afprinten reeksen en romeinse getallen
for i in range(aantal_reeksen): # dit moet hier zelfs niet eens staan!
    print("Reeks", chr(letter_a + 1 + i))
    for j in range(len(reeksen[i])):
        print("Het Romeinse cijfer voor", reeksen[i][j], "is", zetOmNaarRomeinsCijfer(reeksen[i][j]))
    print()
# sommen berekenen en afdrukken
# al deze moesten eigenlijk in een reeks staan en konden blijkbaar gewoon ook in de eerste lus staan
som_min50 = 0
som50_70 = 0
som70_90 = 0
som_meer90 = 0
for i in range(aantal_reeksen): # weer een herhaling
    som = sum(reeksen[i])
    if som < 50:
        som_min50 += 1
    elif som > 50 and som < 70: # dit is dus 0 punten, ge weet al dat hiet niet kleiner is dan 50!
        som50_70 += 1
    elif som > 70 and som < 90:
        som70_90 += 1
    else:
        som_meer90 += 1
# minder dan 50, tussen 50 en 70... in een reeks steken en door een lus laten afpringen
print("Aantal reeksen met een som van gegeneerde getallen minder dan 50:", som_min50)
print("Aantal reeksen met een som van gegeneerde getallen tussen 50 en 70:", som50_70)
print("Aantal reeksen met een som van gegeneerde getallen tussen 70 en 90:", som70_90)
print("Aantal reeksen met een som van gegeneerde getallen van 90 of meer:", som_meer90)