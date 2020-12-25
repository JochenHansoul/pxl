naam = input("Geef de naam van dde manager in: ")
while naam != "xx" and naam != "XX":
    resultaat1 = int(input("test1: "))
    resultaat2 = int(input("test2: "))
    resultaat3 = int(input("test3: "))
    gem = (resultaat1 + resultaat2 + resultaat3) / 3
    if gem < 70:
        print("Niet geslaagd")
    else:
        print("Geslaagd")
    naam = input("Geef de naam van dde manager in: ")