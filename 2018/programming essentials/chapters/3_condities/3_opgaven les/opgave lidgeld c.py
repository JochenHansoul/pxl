burgerlijke_staat = int(input("Geef de burelijke staat in"))
#1 ongehuwd, 1 gehuws, 3 weduwe(naar)
leeftijd = int(input("Geef de leeftijd in"))
if burgerlijke_staat == 1 or leeftijd < 30:
    lidgeld = 25
else:
    lidgeld = 15
print("het lidgeld bedraagt", lidgeld, "euro")