# opgave niet begrepen
karakter = input("Geef een teken in: ")
som = 0
while karakter != "stop":
    karakter = ord(karakter)
    if karakter >= ord("a") and karakter <= ord("z"):
        print(chr(karakter), "kleine letter")
    elif karakter >= ord("A" and "Z"):
        print(chr(karakter), "grote letter")
    elif karakter >= ord("0") and karakter<= ord("9"):
        som += int(chr(karakter))
        print(som)
    else:
        print(chr(karakter), "teken onbekend")
    karakter = input("Geef een teken in: ")