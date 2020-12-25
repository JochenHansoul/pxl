def bepaal_vervoer(code):
    if code == 1:
        vervoer = "met de bus"
    elif code == 2:
        vervoer = "te voet"
    elif code == 3:
        vervoer = "met de trein"
    else:
        vervoer = "met de auto"


teller_auto = 0
minimum = 24 * 60 #grote waarde om kleinste zeker tevinden
teller = 0
som = 0
code = int(input("Geef de code in: "))
while code != 0:
    if code >= 1 and code <= 4:
        tijd = int(input("Geef de tijd in minuten in: "))

    else:
        gemiddelde = som / teller
        print("De gemiddelde duur is", )