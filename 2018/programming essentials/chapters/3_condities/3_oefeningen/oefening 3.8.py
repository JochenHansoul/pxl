afstand_vlucht = int(input("Geef de afstand van de vlucht in: "))
klasse = int(input("Geef de klassa van de vlucht in, 1 toerist, 2 charter, 3 zakenrijs: "))

if afstand_vlucht < 1000:
	prijs_vlucht = float(afstand_vlucht * 0.25)
elif afstand_vlucht < 3000:
	prijs_vlucht = float(afstand_vlucht * 0.20)
else:
	prijs_vlucht = float(afstand_vlucht * 0.12)

if klasse == 1:
	print("Uw vlucht kost: ", prijs_vlucht)
elif klasse == 2:
	print("Uw vlucht kost:", prijs_vlucht - prijs_vlucht / 100 * 20)
else:
	print("Uw vlucht kost:", prijs_vlucht + prijs_vlucht / 100 * 30)
