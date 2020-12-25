PRIJS_ARTIKEL = float(11.5)
aantal_artikelen = int(input("Hoeveel wilt u kopen: "))

prijs_aantal_artikelen = PRIJS_ARTIKEL * aantal_artikelen * 1.21

if prijs_aantal_artikelen <= 1000:
	print("Het bedrag dat de klant moet betalen is: ", prijs_aantal_artikelen + prijs_aantal_artikelen / 100 * 21)
else:
	print("Het bedrag dat de klant moet betalen is: ", prijs_aantal_artikelen + prijs_aantal_artikelen / 100 * 11)