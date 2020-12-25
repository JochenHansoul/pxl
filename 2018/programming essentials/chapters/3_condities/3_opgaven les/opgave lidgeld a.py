burgerlijke_staat = int(input("Geef de burelijke staat in"))
#1 ongehuwd, 1 gehuws, 3 weduwe(naar)
leeftijd = int(input("Geef de leeftijd in"))
if burgerlijke_staat == 1:
    print("het lidgeld bedraagt 25 euro")
elif burgerlijke_staat == 2:
    print("het lidgeld bedraagt 20 euro")
else:
    print("het lidgeld bedraagd 15 euro")
