#lees via toetsenbord een code en een tijd in.
#code: 1 = met bus, 2 = te voet, 3 = met trein, 4 = met auto, 0 einde
#De tijd in minuten om van thuis naar school te gaan.
#bereken gemiddelde duur
#bereken minimale tijd.
#print bus, te voet...
#bereken het percentage dat met de auto komt.
#druk voluit met de bus, te voet, met de trein, met de auto.

#als er niet in de opgave staat voor het niet te controleren moeten we het niet doen.
#voer nu toch een invoercontrole in.

som = 0
teller = 0
min_tijd = 3600 #grote waarde nemen!
teller_auto = 0
code = int(input("Geef een code in, 1 - 4, 0 einde "))
#tijd = int(input("Geef de tijd in minuten in ")) Zet dit in de lus want ge wilt dat het programma stopt wanner de code 0 ingevoerd wordt.
#while not(code >= 0 and code <= 5):
#    code = int(input("Geef een code in: "))


while code != 0:
    if code <= 1 and code <= 4:
        tijd = int(input("Geef de tijd in "))
        som += tijd
        teller += 1
        if tijd < min_tijd:
            min_tijd = tijd
            minimum_vervoer = code
        if code == 4:
            teller_auto += 1
    else:
        print("Foute code, opnieuw:")
    code = int(input("Geef een code in, 1 - 4, 0 einde "))

gemiddelde = som / teller
print("De gemiddelde duur is", gemiddelde)
print("De kleinste tijd is", min_tijd)
if minimum_vervoer == 1:
    vervoer = "met de bus"
elif minimum_vervoer == 2:
    vervoer = "toe voer"
elif minimum_vervoer == 3:
    vervoer = "met de trein"
else:
    vervoer = "met de auto"
print("Dit was", vervoer)
percentage = teller_auto / teller * 100
print("Het percentage dat met de auto komt is", percentage)


if teller == 0:
    print("Geen gegevens ingeveven")
elif teller == 1:
