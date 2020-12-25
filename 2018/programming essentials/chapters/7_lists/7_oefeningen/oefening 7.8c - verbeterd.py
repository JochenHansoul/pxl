lists_punten = [[12, 4, 12, 9], # horizontaal: punten student, vertikaal: punten vakken
                [14, 5, 9, 11],
                [8, 9, 7, 12],
                [7, 12, 11, 10],
                [11, 18, 10, 14]]
list_laagste_punten = []
list_gem = []
list_laagste_student = []
for i in range(4):# dit is blijkbaar wel correct gemaakt maar de i is voor de rijen en de j voor de kolommen
    som = 0 # het is logischer de som hier te zetten i.p.v hierboven en dan op het einde te resetten
    list_vak = [] # list_vak hetzelfde
    for j in range(5):
        list_vak.append(lists_punten[j][i])
        som += lists_punten[j][i]
    list_laagste_punten.append(min(list_vak)) # berekend laatste score
    list_laagste_student.append(list_vak.index(list_laagste_punten[i]) + 1) # berekend laagste student
    list_gem.append(int(som / 5 * 10) / 10) # berekend gemiddelde punten, deze berekening moest niet!
print("lijst laagste punten:", list_laagste_punten)
print("lijst gemiddelden:", list_gem)
print("list_alle_puntenent laagste score:", list_laagste_student)