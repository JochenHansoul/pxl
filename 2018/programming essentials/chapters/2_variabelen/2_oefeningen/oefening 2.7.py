"""Schrijf een programma dat de kosten berekent voor het plaatsen van kamerbreed tapijt.
De gebruiker van het programma geeft de lengte en breedte van het tapijt in (uitgedrukt in meter),
de prijs per m2 en de plaatsingskosten per m2 in.
Als resultaat moet de kostprijs van het tapijt, de plaatsingskosten en de totale kosten afgedrukt worden."""

lengte_tapijt = float(input("Geef lengte in: "))
breedte_tapijt = float(input("Geef breedte in: "))
prijs_vierkante_meter = float(input("Geef de prijs per vierkante meter in: "))
prijs_plaatsingskosten_tapijt = float(input("geef de plaatsingskosten per vierkante meter in: "))

print("kostprijs tapijt:", lengte_tapijt * breedte_tapijt * prijs_vierkante_meter)
print("Plaatsingskosten tapijt:", lengte_tapijt * breedte_tapijt * prijs_plaatsingskosten_tapijt)
print("Totale kosten:", lengte_tapijt * breedte_tapijt * prijs_vierkante_meter + lengte_tapijt * breedte_tapijt * prijs_plaatsingskosten_tapijt)