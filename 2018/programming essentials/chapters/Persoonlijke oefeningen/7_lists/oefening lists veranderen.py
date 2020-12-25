list = [["appel", "banaan", "kers", "kiwi"], ["appel1", "banaan1", "kers1", "kiwi1"], ["appel2", "banaan2", "kers2", "kiwi2"]]
list[0][1] = "fruit"
print(list)
for i in range(3):
    list[i][0] = "fruit"
print()
print(list)