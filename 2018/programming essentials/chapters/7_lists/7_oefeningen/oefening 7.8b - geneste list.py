list_alle_punten = [[12, 4, 12, 9], [14, 5, 9, 11], [8, 9, 7, 12], [7, 12, 11, 10], [11, 18, 10, 14]] # elke geneste list punten verschillende vakken
list_vak = []
list_laagste_punten = []
list_gem = []
list_laagste_student = []
som = 0
for i in range(4):
    for j in range(5):
        list_vak.append(list_alle_punten[j][i])
        som += list_alle_punten[j][i]
    list_laagste_punten.append(min(list_vak)) # berekend laatste score
    list_laagste_student.append(list_vak.index(list_laagste_punten[i]) + 1) # berekend laagste student
    list_gem.append(int(som / 5 * 10) / 10) # berekend gemiddelde punten
    som = 0
    list_vak = [] # reset list
print("lijst laagste punten:", list_laagste_punten)
print("lijst gemiddelden:", list_gem)
print("list_alle_puntenent laagste score:", list_laagste_student)