def hotel_kosten(aantal_nachten):
    gratis = aantal_nachten // 3
    aantal_nachten - gratis
    prijs = aantal_nachten * 140.50
    return  prijs


def vliegtuig_kosten(stad):
    if stad == "Barcelona":
        prijs = 183
    elif stad == "Rome":
        prijs = 220
    elif stad == "Berlijn":
        prijs = 125
    else:
        prijs = 450
    return prijs


def huurauto_kosten(aantal_dagen):
    prijs = aantal_dagen * 40
    if aantal_dagen > 7:
        prijs -= 50
    elif aantal_dagen > 3:
        prijs -= 20
    return prijs


def reis_kosten(stad, aantal_dagen):
    if not (stad == "Barcelona" or stad == "Rome" or stad == "Berlijn" or stad == "Oslo"):
        return "Error"
    else:
        aantal_nachten = aantal_dagen - 1
        prijs_hotel = hotel_kosten(aantal_nachten)
        prijs_vliegtuig = vliegtuig_kosten(stad)
        prijs_huurauto = huurauto_kosten(aantal_dagen)
        totale_prijs = prijs_hotel + prijs_vliegtuig + prijs_huurauto
        return totale_prijs


aantal_dagen = int(input("Geef het aantal dagen in: "))
stad = input("Geef de stad in: ")
prijs = reis_kosten(stad, aantal_dagen)
print(prijs, "€")