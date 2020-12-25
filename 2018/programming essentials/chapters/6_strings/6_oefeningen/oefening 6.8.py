driehoek = int(input("Geef de grootte van de driehoek in: "))
beginletter = input("Geef de beginletter in: ").upper()
letter = ord(beginletter)
for rij in range(1, driehoek + 1):
    for kolom in range(rij):
        print(chr(letter), end="")
        letter += 1
        if letter > ord("Z"):
            letter = ord("A")
    print()