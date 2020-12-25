PERSONEN = 200
list_onquete = [[25, 36, 55, 46, 38],
                [35, 45, 54, 65, 1],
                [75, 66, 44, 10, 5],
                [23, 33, 45, 50, 49]]
list_gewicht = 4 * [0]
for i in range(len(list_onquete)):
    som = 0
    for j in range(1, len(list_onquete[i]) + 1):
        som = j * list_onquete[i][j - 1]
    list_gewicht[i] = int(som / PERSONEN * 100) / 100
    print("Vraag", str(i + 1) + ":", list_gewicht[i])