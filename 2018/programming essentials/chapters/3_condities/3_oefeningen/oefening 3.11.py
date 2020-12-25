sterren = int(input("geef het aantal sterren in: "))
maaltijden = input("Geef een letter in 'O' enkel ontbijt, 'H' half pension, 'V' vol pension en 'A' all-inclusive: ")
nachten = int(input("Geef het aantal nachten in: "))
seizoen = input("Geef een letter in 'H' hoogseizoen, 'L' laagseizoen, 'T' tussenseizoen: ")
kostprijs = 0
#berekening voor rating:
if sterren < 2:
    kostprijs += 30
elif sterren < 4:
    kostprijs += 40
else:
    kostprijs += 55
#berekening met maaltijden erbij:
if maaltijden == "O":
    kostprijs *= 1.2
elif maaltijden == "H":
    kostprijs *= 1.5
elif maaltijden == "V":
    kostprijs *= 1.6
else:
    kostprijs *= 1.6 + 80
#extra berekening voor laag seizoen:
if seizoen == "L" and (maaltijden == "O" or maaltijden == "H"):
    kostprijs *= 0.9
#berekenig per nacht:
kostprijs *= nachten
#prijs afprinten:
print("De prijs is:", kostprijs)