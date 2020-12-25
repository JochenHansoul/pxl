rijen = int(input("Geef het aantal rijen in: "))
kolommen = int(input("Geef het aantal kolommen in: "))
teken = input("geef het teken in: ")
for i in range(rijen):
    for j in range(kolommen):
        print(teken, "\t", end="")
    print()