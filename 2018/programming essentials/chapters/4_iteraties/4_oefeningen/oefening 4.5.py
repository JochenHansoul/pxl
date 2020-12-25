getal = int(input("Geef een getal in: "))
#while getal < 1 or getal > 100:
while not(getal >= 1 and getal <= 100):
    if getal < 1:
        print("Fout! Het getal moet groter zijn dan 1")
    else:
        print("Fout! Het getal moet kleiner zijn dan 100.")
    getal = int(input("Geef een getal in: "))
print(getal)