from random import randint

list = [[0, 0, 0],
        [0, 0, 0],
        [0, 0, 0],
        [0, 0, 0],
        [0, 0, 0]]
print(list)
top = ["PXL-IT", "PXL-Buisness", "PXL-Education"]
links = ["Aleen in auto", "Carpooling", "Openbaar vervoer", "Fiets", "Te voet"]
for i in range(150):
    vervoersmiddel = randint(0, 4)
    departement = randint(0, 2)
    list[vervoersmiddel][departement] += 1
print(top)
for i in range(len(list)):
    #print(links[i], end="")
    for j in range(len(list[i])):
        print(list[i][j], "", end="")
    print()
for i in range(len(list)):
    som = sum(list[i])
    if som < 30:
        print(links[i], "is minder dan 30 keer gekozen.")
    print("Het persentage", links[i], "is", str(int(som / 150 * 10000) / 100) + "%")