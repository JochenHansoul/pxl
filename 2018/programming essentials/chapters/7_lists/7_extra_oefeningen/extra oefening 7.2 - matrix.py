LENGTE_MATRIX = 7
som = 0
matrix_list = LENGTE_MATRIX * [[0, 0, 0, 0, 0, 0, 0]] # aantal 0 is breedte
for i in range(LENGTE_MATRIX):
    print("rij", i + 1)
    for j in range(len(matrix_list[i])):
        matrix_list[i][j] = int(input("Geef een getal in: "))
    som += matrix_list[i][i]
print(matrix_list)
print(som)