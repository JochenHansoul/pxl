getal1 = int(input("Geef getal 1 in: "))
getal2 = int(input("Geef getal 2 in: "))
if getal1 < getal2:
	print("Het kleinste getal is: ", getal1)
	print("Het kwadraat van het kleinste getal is: ", getal1 ** 2)
	print("Het grootste getal gedeeld door het kleinste getal is: ", getal2 / getal1)
else:
	print("Het kleinste getal is: ", getal2)
	print("Het kwadraat van het kleinste getal is: ", getal2 ** 2)
	print("Het grootste getal gedeeld door het kleinste getal is: ", getal1 / getal2)

