#klas 5 studenten, bereken de gemiddelde leeftijd.
leeftijd = 0
for i in range(5):
    leeftijd += int(input("Geef de leeftijd van de student in: "))
leeftijd /= 5
print("De gemiddelde leeftijd is", leeftijd)