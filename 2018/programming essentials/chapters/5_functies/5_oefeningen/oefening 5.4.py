from random import randint

def getal_vergelijken(getal):
    if getal < willekeurig_getal:
        print("hoger")
    elif getal > willekeurig_getal:
        print("lager")
    else:
        print("proficiat, getal geraden")


teller = 0
killswitch = 0
willekeurig_getal = randint(1, 10)
while killswitch != 1 and teller < 4:
    getal_gebruiker = int(input("geef een getal in: "))
    getal_vergelijken(getal_gebruiker)
    teller += 1
    if getal_gebruiker == willekeurig_getal:
        killswitch = 1