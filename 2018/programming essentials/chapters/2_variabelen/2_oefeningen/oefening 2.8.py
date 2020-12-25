"""Wat kost mijn auto?
Prijsbewuste personen willen weten hoeveel hun auto echt kost.
Achtereenvolgens wordt ingevoerd:
aantal afgelegde km per jaar (afgelegde_km)
verbruik in l per 100 km (verbruik)
prijs van 1 l brandstof (prijs_per_liter)
Als uitvoer wordt verwacht:
de totale kosten per jaar voor het opgegeven aantal km
de kostprijs per km rijden."""
km_1_year = float(input("Aantal kilometers auto per jaar: "))
fuel_for_100_km = float(input("Verbruik in l per 100 km: "))
price_1liter_fuel = float(input("prijs van 1 l brandstof: "))
#print("Totale kosten per jaar voor", kilometers_auto_jaar, "is", int(kilometers_auto_jaar / verbruik_per_100kilometer * prijs_brandstof * 100) / 100)
#print("Kostprijs per km is", int(verbruik_per_100kilometer * prijs_brandstof) / 100)
fuel_in_one_year = km_1_year / 100 * fuel_for_100_km
cost_for_one_year = fuel_in_one_year / price_1liter_fuel
cost_1_km = fuel_in_one_year / 100 * price_1liter_fuel
print("De kosten voor in jaar is", cost_for_one_year)
print("De kosten voor 1 km zijn", cost_1_km)