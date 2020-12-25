# De prijs per kind wordt als volgt berekend:
# + indien kindercode "A" is geldt: kinderen in 1- en 2-sterrenhotels zijn gratis, evenals in alle hotels die niet in Brussel gelegen zijn.
# + In alle andere gevallen betalen kinderen 50% van de prijs van een volwassene.

def prijs_per_persoon(hotelcode, sterren):
    if hotelcode[:2] == "HI":
        prijs = 70
    else:
        if sterren >= 4 or sterren == 3 and (hotelcode[:2] == "BR" or hotelcode[:2] == "AN"):
            prijs = 60
        elif sterren == 3:
            prijs = 56
        else:
            prijs = 48
    return prijs


def prijs_kinderen(kindercode, sterren):
    if kindercode == "A" and (sterren <= 2 or hotelcode[:1] != "BR"):
        kinderprijs = 0
    else:
        kinderprijs = 1/2
    return kinderprijs


hotelcode = input("Geef de hotelcode in (2 letters gevolgd door 4 cijfers): ")  # stopls al / wordt ingegeven.
while hotelcode != "/":
    volwassenen = int(input("Geef het aantal volwassenen in: "))
    kinderen = int(input("Geef het aantal kinderen in: "))
    sterren = int(input("Geef het aantal sterren in: "))
    kindercode = input("Geef de kindercode in: ")
    prijs_hotel = prijs_per_persoon(hotelcode, sterren)
    kinderprijs = prijs_kinderen(kinderen, sterren)
    totale_prijs = volwassenen * prijs_hotel + kinderen * prijs_hotel * kinderprijs
    # Maak een lijst met per hotel: het aantal sterren, de prijs per persoon per nacht, de prijs per kind per nacht en de totale prijs.
    print("hotel", "\t", "sterren", "\t", "prijs persoon", "\t", "prijs kind", "\t", "totaalprijs")
    print(hotelcode, "\t", "*" * sterren, "\t", "\t", prijs_hotel, "\t", "\t", "\t", prijs_hotel * kinderprijs, "\t", "\t", "\t", "\t", totale_prijs)
    print()
    hotelcode = input("Geef de hotelcode in (2 letters gevolgd door 4 cijfers): ")  # stopls al / wordt ingegeven.