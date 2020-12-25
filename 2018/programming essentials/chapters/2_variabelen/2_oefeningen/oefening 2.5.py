fahrenheid = float(input("Aantal graden Fahrenheid: "))

celsius = (fahrenheid - 32) / (9 / 5)

print("Het aantal graden celsius is:", int(celsius * 10) / 10)

#afronden op 1 dec: * 10 + 0.5 afkappen / 10
#celsius_afgerond = int(celsius * 10 + 0.5) / 10