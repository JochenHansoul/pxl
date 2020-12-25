# Hansoul Jochen - 1TIN C
from random import randint

def basisscore(naam, jaar, cinema):
    list_ascii = []
    if len(naam) < len(cinema):
        kortste = naam
        for i in range(len(naam)):
            if naam[i] == cinema[i]:
                list_ascii.append(ord(naam[i]))
    else:
        kortste = cinema
        for i in range(len(cinema)):
            if naam[i] == cinema[i]:
                list_ascii.append(ord(naam[i]))
    """for i in range(len(kortste)):
        vorige = 0
        while vorige < len(kortste) + 1:
            positie = kortste.index(chr(list_ascii[i]), vorige, len(naam))
            list_ascii[i] *= positie + 1
            vorige = positie + 1"""
    for i in range(len(list_ascii)):
        positie = kortste.index(chr(list_ascii[i]))
        list_ascii[i] *= positie + 1
    basisscore = sum(list_ascii)
    basisscore += jaar
    return basisscore

list_studenten = [[]]
list_som = []
teller = 0
list_studenten[teller].append(input("Geef jouw naam in: "))
while not(list_studenten[teller][0] == "xxx" or list_studenten[0] == "qqq"):
    list_studenten[teller].append(int(input("In welk jaar ben jij geboren?: ")))
    list_studenten[teller].append(int(input("Hoe vaak ga je naar de kinepolis per maand (1=weinig, 2=matig, 3=veel): ")))
    list_studenten[teller].append(input("Wat eet je bij kenepolis (P=popcorn, C=chips, N=niets): "))
    som = basisscore(list_studenten[teller][0], list_studenten[teller][1], "cinema")
    if list_studenten[teller][2] == 1:
        som /= 2
    elif list_studenten[teller][2] == 2:
        som *= 2
    else:
        som *= 3
    if list_studenten[teller][3] == "N" and list_studenten[teller][3] <= 2:
        som -= 1050
    teller += 1
    list_studenten.append([])
    list_studenten[teller].append(input("Geef jouw naam in: "))
    list_som.append(som)
print(list_studenten)
# random getal berekenen:
getal = randint(1, 9999)
while str(getal)[-1:] != "0":
    getal = randint(1, 9999)
    while getal > 5000 and getal % 2 != 0:
        getal = randint(1, 9999)
filmtickets = 0
for i in range(len(str(getal))):
    filmtickets += int(str(getal)[i])
# uitprinten
hoogste = max(list_som)
winnaar = list_studenten.index(hoogste)
print(hoogste)
print(list_studenten[winnaar][0], "jij hebt gewonnen\n", "jouw score is: ", hoogste, "\nHet random gegenereerd getal is", getal, "\nIngrid, jij wint hierbij", filmtickets, "filmtickets.")