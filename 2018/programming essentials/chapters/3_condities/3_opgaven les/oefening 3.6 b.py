jaar = int(input("Geef het jaar van de film in: "))
rating = int(input("Geef de rating in: "))
prijs  = 5
if 2018 - jaar < 2:
    prijs += 1
if rating > 3:
    prijs += 2
elif rating > 1:
    prijs += 1
if prijs > 7:
    prijs = 7
print("De prijs van de film is:", prijs)