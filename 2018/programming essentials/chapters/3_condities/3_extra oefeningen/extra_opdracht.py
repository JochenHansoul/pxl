# Geef een getal in. Ga na of dit getal kleiner of groter is dan 10,
# tussen 10 en 100 is (grenzen inbegrepen) of groter is dan 100
# druk een gepaste foutmelding af.

getal = int(input("geef een getal in: "))
if getal < 10:
    print("Het getal is kleiner dan 10")
elif getal <= 100:
    print("Het getal ligt tussen 10 en 100.")
else:
    print("Het getal is groter dan 100")