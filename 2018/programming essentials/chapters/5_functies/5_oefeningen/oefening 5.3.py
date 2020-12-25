def berekening_lidgeld(leeftijd, kinderen, jaren_lid, inkomen):
    lidgeld = 100
    if leeftijd > 60:
        lidgeld -= 15
    if kinderen > 0:
        vermindering = kinderen * 7.5
        if vermindering < 35:
            lidgeld -= vermindering
        else:
            lidgeld -= 35
    if jaren_lid >= 20:
        lidgeld -= 12.5
    if inkomen < 7500:
        lidgeld -= 25
    if lidgeld < 50:
        lidgeld = 50
    return lidgeld


HUIDIG_JAAR = 2018
naam = input("Geef de naam in: ")
while naam != "x" and naam != "X":
    leeftijd = int(input("Geef de leeftijd in :"))
    kinderen = int(input("Geef het aantal kinderen in: "))
    inkomen = int(input("Geef het inkomen in: "))
    aansluitingsjaar = int(input("Geef het aansluitingsjaar in: "))
    jaren_lid = HUIDIG_JAAR - aansluitingsjaar
    print(naam)
    print(berekening_lidgeld(leeftijd, kinderen, jaren_lid, inkomen))
    naam = input("Geef de naam in: ")