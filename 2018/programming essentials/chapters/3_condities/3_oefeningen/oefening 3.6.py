jaar_film = int(input("Geef het jaar in: "))
rating_film = int(input("Geef de rating weer: "))
BASISPRIJS = 5
if rating_film < 1 or rating_film > 5:
    print("Foutieve code")
else:





if jaar_film >= 2016:
	if rating_film < 2:
		print("De DVD kost 5 €")
	elif rating_film < 4:
		print("De DVD kost 6 €")
	else:
		print("De DVD kost 7 €")
else:
	if rating_film < 2016:
		print("De DVD kost 6 €")
	else:
		print("De DVD kost 7 €")