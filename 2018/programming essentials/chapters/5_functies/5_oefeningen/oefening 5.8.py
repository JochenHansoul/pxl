OPP_PER_UUR = 160  # dit is een constante, en alle constanten moeten helemaal bovenaanstaan staan, boven dif
MAX_OPPERVLAK_PPD = OPP_PER_UUR * 8


def personen(oppervlakte, MAX_OPPERVLAK_PPD):
    berekening1 = oppervlakte / MAX_OPPERVLAK_PPD
    aantal_personen = berekening1 // 1
    if berekening1 % 1 > 0:
        aantal_personen += 1
    return aantal_personen


def kostprijs(oppervlakte, opp_per_uur, aantal_personen):
    uren_werk = oppervlakte / (opp_per_uur * aantal_personen)
    if uren_werk % 1 != 0:
        uren_werk = uren_werk // 1 + 1
    prijs = uren_werk * 12.5
    return prijs


def uren(oppervlakte, MAX_OPPERVLAK_PDD):
    uren = oppervlakte / MAX_OPPERVLAK_PPD % 1 * 8
    if (uren % 1) != 0:
        uren //= 1
        uren += 1
    return int(uren)

oppervlakte = int(input("Geef het aantal vierkante meter in: "))
while oppervlakte != 0:
    aantal_personen = int(personen(oppervlakte, MAX_OPPERVLAK_PPD))
    prijs = kostprijs(oppervlakte, OPP_PER_UUR, aantal_personen)
    print("aantal personen:", aantal_personen, "prijs:", prijs, "€")
    if oppervlakte < MAX_OPPERVLAK_PPD:
        print("1 persoon werkt", oppervlakte / MAX_OPPERVLAK_PPD * 8, "uur.")
    elif oppervlakte % MAX_OPPERVLAK_PPD == 0:
        print(aantal_personen, "persoon/personen werken 8 uur.")
    else:
        print(aantal_personen - 1, " persoon/personen werken 8 uur, 1 persoon werkt", uren(oppervlakte, MAX_OPPERVLAK_PPD), "uur.")
    oppervlakte = int(input("Geef het aantal vierkante meter in: "))