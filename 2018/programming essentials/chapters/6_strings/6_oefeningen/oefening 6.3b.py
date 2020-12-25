n = int(input("Geef een getal in: "))
som = 0
for i in range(n):
    karakter = input("Geef een karakter in: ")
    if karakter.isalnum():
        if karakter.isupper():
            print(karakter, "is een hoofdletter.")
        elif karakter.islower():
            print((karakter, "is een kleine letter."))
        else:
            karakter = int(karakter)
            som += karakter
            print(som)
    else:
        print("karakter onbekend.")