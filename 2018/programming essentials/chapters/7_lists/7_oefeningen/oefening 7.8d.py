lists_punten = [[0, 0, 0, 0], # horizontaal: punten student, vertikaal: punten vakken
                [0, 0, 0, 0],
                [0, 0, 0, 0],
                [0, 0, 0, 0],
                [0, 0, 0, 0]]
for i in range(5):
    print("Geef de punten voor student", i + 1, "in.")
    for j in range(4):
        lists_punten[i][j] = int(input("punten: "))
    print()
list_laagste_punten = []
list_gem = []
list_laagste_student = []
for i in range(4):# dit is blijkbaar wel correct gemaakt maar de i is voor de rijen en de j voor de kolommen
    som = 0
    list_vak = []
    for j in range(5):
        list_vak.append(lists_punten[j][i])
        som += lists_punten[j][i]
    list_laagste_punten.append(min(list_vak)) # berekend laatste score
    list_laagste_student.append(list_vak.index(list_laagste_punten[i]) + 1) # berekend laagste student
    list_gem.append(int(som / 5 * 10) / 10) # berekend gemiddelde punten, deze berekening moest niet!
print("lijst laagste punten:", list_laagste_punten)
print("lijst gemiddelden:", list_gem)
print("studenten laagste score:", list_laagste_student)