personeelsnummer = int(input("Geef het personeelsnummer in: "))
aantal_mannen = 0
aantal_vrouwen = 0
while personeelsnummer != 0:
    geslacht = int(input("Geef het geslacht in, 0 = vrouw, 1 = man: "))
    while geslacht < 0 or geslacht > 1:
        geslacht = int(input("Geef het geslacht in, 0 = vrouw, 1 = man: "))
    leeftijd = int(input("Geef de leeftijd in: "))
    brutoloon = int(input("Geef het brutoloon in: "))
    if geslacht == 1:
        if leeftijd > 34 or brutoloon > 1800:
            aantal_mannen += 1
    else:
        if leeftijd < 25:
            aantal_vrouwen += 1
    personeelsnummer = int(input("Geef het personeelsnummer in: "))
print("Het aantal manner ouder dan 34 of loon meer dan 1800 is", aantal_mannen)
print("Het aantal vrouwen jonger dan 25 is", aantal_vrouwen)