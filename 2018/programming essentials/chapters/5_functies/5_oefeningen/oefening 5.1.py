#Een bankbediende wenst snel te kunnen uitrekenen hoeveel de waarde van een bepaald bedrag in euro is in US dollar.
# Aan het begin van het programma geeft hij de waarde van de euro in t.o.v. de US dollar, vb. 1 euro = 1,28 US dollar (1,28 wordt ingevoerd).
# Vervolgens worden bedragen in euro ingevoerd, waarna de waarde in US dollar getoond wordt. De omzetting gebeurt via een functie.
# Het programma eindigt als voor het bedrag in euro 0 wordt ingevoerd.
def omrekenen_naar_dollar(bedrag, wisselkoers):
    #stel ge zet hier koers +=1 in dan gaat dit niks doen want koers is hier niet in gedefineerd.
    print(bedrag * wisselkoers, "dollar")


koers = float(input("Geef de waarde van de euro t.o.v. de dollar in: "))
euro = float(input("Geef het bedrag in euro: "))
while euro != 0:
    omrekenen_naar_dollar(euro, koers)
    euro = float(input("Geef het bedrag in: "))