from random import randint

def berekening():
    groter_getal = randint(0, 20)
    kleiner_getal = randint(0, groter_getal)
    return groter_getal, kleiner_getal


for i in range(1, 6):
    print("Reeks", i)
    for j in range(1, 6):
        eerste_getal, tweede_getal = berekening()
        print(j, ")", eerste_getal, "-", tweede_getal, "=")
    print()
# Dit kan in Python maar niet in de andere programeertalen.
# Python is gebouwd vanuit een wiskundig perspectief.