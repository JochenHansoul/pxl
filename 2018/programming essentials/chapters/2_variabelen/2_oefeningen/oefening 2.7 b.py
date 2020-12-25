"""Schrijf een programma dat de kosten berekent voor het plaatsen van kamerbreed tapijt.
De gebruiker van het programma geeft de lengte en breedte van het tapijt in (uitgedrukt in meter),
de prijs per m2 en de plaatsingskosten per m2 in.
Als resultaat moet de kostprijs van het tapijt, de plaatsingskosten en de totale kosten afgedrukt worden."""
#input
length_carpet = float(input("Geef de lengte in: "))
width_carpet = float(input("Geef de breette in: "))
carpet_costs_square_meter = float(input("Geef de prijs per vierkante meter in: "))
placing_costs_square_meter = float(input("Geef de plaatsingskosten per vierkante meter in: "))
#calculations
surface_carpet = length_carpet * width_carpet
price_carpet = surface_carpet * carpet_costs_square_meter
installment_price = surface_carpet * placing_costs_square_meter
total_cost = price_carpet + installment_price
#output
print("Het tapijt kost:", price_carpet, "de plaatsingskosten zijn:", installment_price, "de totaalkosten zijn:", total_cost)