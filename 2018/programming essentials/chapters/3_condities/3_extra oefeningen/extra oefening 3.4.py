naam_speler = input("Geef de naam in: ")
prijs_vorig_seizoen = float(input("Geef prijs vorig seizoen in: "))
leeftijd = int(input("Geef de leeftijd in: "))
gemiddeld_beoordeling = int(input("Geef de gemiddelde bveoordeling in (1-10): "))
type_speler = input("Geef het type speler in (\"Aanvaller\", \"Middenvelder\", \"Verdediger\", \"Doelman\"): ")
aantal_doelpunten = int(input("Geef het aantal goalen niet geblokkeerd in voor de doelman of het aantal punten gescoord voor de anderen): "))
#berekeningen
if leeftijd < 25:
    nieuwe_prijs = prijs_vorig_seizoen * 1.1
elif leeftijd > 30:
    nieuwe_prijs = prijs_vorig_seizoen * 0.95
else:
    nieuwe_prijs = prijs_vorig_seizoen
if type_speler == "Aanvaller":
    if aantal_doelpunten < 6:
        nieuwe_prijs += aantal_doelpunten * 10000
    else:
        nieuwe_prijs += 50000 + (aantal_doelpunten - 5) * 20000
else:
    nieuwe_prijs *= 10000 * gemiddeld_beoordeling
    if type_speler == "Doelman" and aantal_doelpunten >= 20:
        nieuwe_prijs -= (aantal_doelpunten - 20) * 9000
print("Naam:", naam_speler, "prijs vorig seizoen:", prijs_vorig_seizoen, "en de nieuwe prijs is:", nieuwe_prijs)