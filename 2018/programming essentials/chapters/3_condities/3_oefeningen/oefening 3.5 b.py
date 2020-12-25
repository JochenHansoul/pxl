EENHEIDSPRIJS = 11.5
BTW = 1.21
aantal_artikelen = int(input("Geef het aantal artikels in: "))
totale_prijs = EENHEIDSPRIJS * BTW * aantal_artikelen
if totale_prijs > 1000:
    totale_prijs *= 0.9
print("Uw prijs is", totale_prijs, "€")