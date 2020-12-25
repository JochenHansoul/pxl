hoeveelheid_water = int(input("Geef het verbruikte water in in m³: "))
bedrag_water = 25
if hoeveelheid_water <= 30:
    print(end="")
elif hoeveelheid_water <= 200:
    bedrag_water += (hoeveelheid_water - 30)
elif hoeveelheid_water <= 500:
    bedrag_water += (hoeveelheid_water - 30) * 1.15
else:
    bedrag_water += (hoeveelheid_water - 30) * 1.175
print("Het bedrag dat u moet betalen is:", bedrag_water)