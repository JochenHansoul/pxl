# geneste lijst
# boter kaas en eiëren

# Maak een geneste list bestaande uit 4 rijen en 6 kolommen
list = []
for rijnr in range(1,5):
    rij = []
    for kolnr in range(1, 7):
        rij.append(rijnr * kolnr)
    list.append(rij)
# print rij per rij
for i in range(0, 4):
    print(list[i])
# bereken de som per kolom en druk af
for j in range(6):
    som = 0
    for i in range(0, 3):
        som += list[i][j] # de buitenste lus is de lus die de kolom doorloopt, i zijn altijd rijen, j zijn kolommen
    print("De som van kolom,", j + 1, "=", som)
#cbereken de som per rij en druk af
for i in range(4):
    som = 0
    for j in range(6):
        som += list[i][j]
    print("De som van de rij", i + 1, "=", som)
# alternatief
for i in range(4):
    print("De som van rij", i + 1, "=", sum(list[i])) # is een ingebouwde som voor een lijst, kan alleen bij rijen.