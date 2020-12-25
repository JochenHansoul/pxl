list_tshirts = [[45, 102, 19, 55, 0],
                [79, 47, 58, 22, 46],
                [109, 33, 112, 0, 0]]
list_size = ["small", "medium", "large"]
list_color = ["rood", "wit", "blauw", "orange", "zwart"]
list_derden = []
for i in range(3):
    size = 0
    for j in range(5):
       size += (list_tshirts[i][j])
    list_derden.append(size / 3)
for i in range(3):
    for j in range(5):
        if list_tshirts[i][j] <= list_derden[i]:
            print(list_size[i], list_color[j], "te weinig, ", end="")
    print()