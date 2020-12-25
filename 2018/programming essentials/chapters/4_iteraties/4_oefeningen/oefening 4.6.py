artikelnummer = int(input("Geef het artikelnummer in: "))
print_nummer = 0
hoeveelheid = 0
eenheidsprijs = 0
while artikelnummer != 999:
    hoeveelheid = int(input("Geef de hoeveelheid in: "))
    eenheidsprijs = int(input("Geef de eenheidsprijs in: "))

    print("Artiekelnummer", artikelnummer, "met", hoeveelheid, "die", eenheidsprijs, "kosten")
    print("De toteelprijs is:", hoeveelheid * eenheidsprijs)
    artikelnummer = int(input("Geef het artikelnummer in: "))
