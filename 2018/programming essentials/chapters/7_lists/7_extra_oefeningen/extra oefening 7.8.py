GETALA = ord("a")

def toon_bord(veld):
    for i in range(len(veld)):
        for j in range(len(veld[i])):
            print(veld[i][j], end="")
        print()
    print()


def geef_rij_kolom(veld, speler, getala):
    print("Speler", speler, end="")
    ingave = input(" geef een rij en een kolom in (vb: 1a, 2b): ")
    rij = int(ingave[0]) - 1
    kolom_teken = ingave[1]
    kol = ord(kolom_teken) - getala
    while not(veld[rij][kol] == "." and rij >= 0 and rij <= 2 and kol >= 0 and kol <= 2):
        ingave = input("Geef een geldige rij en kolom in (vb: 1a): ")
        rij = int(ingave[0]) - 1
        kolom_teken = ingave[1]
        kol = ord(kolom_teken) - getala
    veld[rij][kol] = speler


def winnaar(veld, teken):
    diagonaal = 0
    for i in range(3):
        horizontaal = 0
        verticaal = 0
        for j in range(3):
            # horizontaal
            if veld[i][j] == teken:
                horizontaal += 1
            # vertikaal
            if veld[j][i] == teken:
                verticaal += 1
            if horizontaal == 3 or verticaal == 3:
                print(teken, "heeft gewonnen")
                return True
        # diagonaal
        if veld[i][i] == teken:
            diagonaal += 1
    if diagonaal == 3 or veld[0][2] == teken and veld[1][1] == teken and veld[2][0] == teken:
        print(teken, "heeft gewonnen")
        return True
    return False


speler = "x"
veld = [[".", ".", "."],
        [".", ".", "."],
        [".", ".", "."]]
gewonnen = False
teller = 0
while gewonnen != True and teller < 9:
    geef_rij_kolom(veld, speler, GETALA)
    toon_bord(veld)
    gewonnen = winnaar(veld, speler)
    if speler == "x":
        speler = "o"
    else:
        speler = "x"
    teller += 1
if teller == 9:
    print("gelijkspel")