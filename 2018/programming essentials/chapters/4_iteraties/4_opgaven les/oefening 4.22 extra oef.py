#rij    kol
#1      5
#2      4
#3      3
#4      2
#5      1
for rij in range(1, 6):
    for kol in range(1, 7 - rij):
        print(rij, end="")
    print()