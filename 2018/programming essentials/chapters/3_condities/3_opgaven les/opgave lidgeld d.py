burgerlijke_staat = int(input("Geef de burelijke staat in"))
#1 ongehuwd, 1 gehuws, 3 weduwe(naar)
leeftijd = int(input("Geef de leeftijd in"))
if burgerlijke_staat == 1:
    lidgeld = 25
elif burgerlijke_staat == 2 and leeftijd < 30:
    lidgeld = 20
else:
    lidgeld = 15
print("Het lidgeld bedraagt", lidgeld, "euro.")