from random import randint


def zeeslag(gezonken, letter_A):
    invoer = input("Geef een rij en een kolom in (1A - 3D): ")
    rij = int(invoer[:1])
    kolom = ord(invoer[1:]) - letter_A + 1
    if list_zeeslag[rij][kolom] == "x":
        print("Raak!")
        list_zeeslag[rij][kolom] = ""
        gezonken += 1
    else:
        print("Mis!")
    return gezonken


list_zeeslag = [["", "", "", "", "", ""],
                ["", "", "", "", "", ""],
                ["", "", "", "", "", ""],
                ["", "", "", "", "", ""],
                ["", "", "", "", "", ""]]
x = 0
while x < 3:
    a = randint(1, 3)
    b = randint(1, 3)
    if list_zeeslag[a][b] != "x" and list_zeeslag[a - 1][b] != "x" and list_zeeslag[a + 1][b] != "x" and list_zeeslag[a][b - 1] != "x" and list_zeeslag[a][b + 1] != "x":
        list_zeeslag[a][b] = "x"
        x += 1
print("Schiet op de schepen!")
letter_A = ord("A")
gezonken_schepen = 0
teller = 0
while gezonken_schepen < 3:
    gezonken_schepen = zeeslag(gezonken_schepen, letter_A)
    teller += 1
print("\nAantal schoten nodig:", teller)