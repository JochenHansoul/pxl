aantal_rijen = int(input("Geef het aantal rijen in: "))
aantal_kolommen = int(input("Geef het aantal kolommen in: "))
for rij in range(1, aantal_rijen + 1):
    for kolom in range(1, aantal_kolommen + 1):
        print((rij - 1) * aantal_rijen + kolom, "\t", end="")
    print()