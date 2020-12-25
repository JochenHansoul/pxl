from random import randint

def berekening1():
    getal1 = randint(0, 20)
    return getal1


def berekening2(eerst):
    getal2 = randint(0, eerst)
    return getal2


for i in range(1, 6):
    print("Reeks", i)
    for j in range(1, 6):
        eerste_getal = berekening1()
        tweede_getal = berekening2(eerste_getal)
        print(j, ")", eerste_getal, "-", tweede_getal, "=")
    print()
#het was hier toch niet de bedoeling dat je een functie gebtuikt maar ze zijn wel goed.
#In andere programeertalen zijn de functies een afgesloten geheel. MOET GETALLEN INGEVEN DIE JE WILT LATEN BEREKENEN!