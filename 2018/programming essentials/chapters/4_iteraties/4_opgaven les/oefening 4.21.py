grootte = int(input("grootte van de driehoek: "))
for rij in range(1, grootte + 1):
    for kol in range(rij):
        print("a", "\t", end="")
    print()