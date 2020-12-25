totale_premie = 0
hoogste_premie = 0
familienaam = input("Geef de familienaam in: ")
while not(familienaam == "/" or familienaam == "***"):
    voornaam = input("Geef de noornaam in: ")
    aantal_dienstjaren = int(input("Geef het aantal dienstjaren in: "))
    while aantal_dienstjaren < 0 or aantal_dienstjaren > 40:
        aantal_dienstjaren = int(input("Geef het aantal dienstjaren in: "))
    if aantal_dienstjaren >= 5:
        premie = aantal_dienstjaren * 25
        totale_premie += premie
        if premie > hoogste_premie:
            hoogste_premie = premie
    else:
        premie = 0
    print(familienaam, voornaam, "leeftijd:", aantal_dienstjaren, 'premie:', premie)
    familienaam = input("Geef de familienaam in: ")
print("De totale premie is:", totale_premie)
print("De hoogste premie is:", hoogste_premie)