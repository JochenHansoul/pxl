from random import randint
list_roman = ["XL", "X", "IX", "V", "IV", "I"]
waarde = [40, 10, 9, 5, 4, 1]


def zetomnaarromeinscijfer(getal, roman, list_cijfers):
    uitkomst = ""
    for i in range(len(list_cijfers)): # hier waarde en niet cijfer aan geven lukt wel in Python maar niet in andere programeertalen
        aantal = getal // list_cijfers[i]
        getal = getal % list_cijfers[i] # hier wordt het getal verminderd
        uitkomst += aantal * roman[i]
    return uitkomst


tel = 4 * [0] # dit is voor de laatste 4 sommen te genereren
letter = input("Geef letter: ")
for ascii in range(ord("a"), ord(letter) + 1):
    print("reeks", chr(ascii))
    getal1 = randint(1, 49)
    print("Het romeinse cijfer voor", getal1, "is", zetomnaarromeinscijfer(getal1, list_roman, waarde))
    getal2 = randint(1, 49)
    som = getal1
    while getal2 > getal1:
        getal1 = getal2
        som += getal1
        print("Het romeinse cijfer voor", getal1, "is", zetomnaarromeinscijfer(getal1, list_roman, waarde))
        getal2 = randint(1, 49)
    if som < 50:
        cat = 0 # cat is van categorie
    elif som < 70:
        cat = 1
    elif som < 90:
        cat = 2
    else:
        cat = 3
    tel[cat] += 1
print()
tekst = ["minder dan 50", "tussen 50 en 70", "tussen 70 en 90", "vab 90 of meer"]
for i in range(len(tel)):
    print("aantal reeksen met een som van gegenereerde getallen", tekst[i], ":", tel[i])