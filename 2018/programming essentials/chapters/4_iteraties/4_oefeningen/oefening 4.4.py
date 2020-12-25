#gewicht tussen de 50 end e 120 kilo!
print("Geef de persentages voor de zwaartekracht van de maan, jupiter en mars in:")
zw_maan = float(input("Zwaartekracht Maan: ")) / 100
zw_jupiter = float(input("Zwaartekrach Jupiter: "))/ 100
zw_mars = float(input("Zwaartekracht Mars: "))/ 100
for gewicht in range(50, 121, 5):
    print("Aarde:", gewicht)
    print("Maan:", gewicht * zw_maan )
    print("Jupiter:", gewicht * zw_jupiter)
    print("Mars:", gewicht * zw_mars)
    print()