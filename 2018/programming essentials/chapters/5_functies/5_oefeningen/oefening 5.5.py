#er mag geen integer worden gebruikt.
def controleer(lidnummer):
    getal2 = lidnummer1 // 100000
    getal2 %= 10
    getal4 = lidnummer1 // 1000
    getal4 %= 10
    getal24 = getal2 * 10 + getal4
    getal67 = lidnummer1 % 100
    if getal24 == getal67:
        return "gratis"
    else:
        return "betalen"


lidnummer1 = 1234567
antwoord = controleer(lidnummer1)
print(antwoord)