def boete(aantal_boeken, aantal_dagen):
    boete = 0.07 * aantal_boeken + 0.07 * aantal_dagen
    if aantal_dagen >= 45:
        boete += 0.84
    return boete


teller = 0
bibliotheekgebruiker = input("geef uw naam in: ")
while bibliotheekgebruiker != "xx":
    boeken = int(input("geef het aantal boeken in: "))
    dagen = int(input("Geef hoelang de uitleer termijn verstreken is: "))
    bedrag = boete(boeken, dagen)
    if dagen >= 45:
        teller += 1
    print(bibliotheekgebruiker, "heeft", bedrag, "euro boete.")

    bibliotheekgebruiker = input("geef uw naam in: ")
print("Er werden", teller, "aanmalingsbrieven verstuurd.")