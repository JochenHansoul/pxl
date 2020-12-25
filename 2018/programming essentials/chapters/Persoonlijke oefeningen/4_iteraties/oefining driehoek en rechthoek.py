#maar een driehoek die naar beneden vermeerderd, een vierkant en een driehoek die naar beneden versmalt
#de gebruiker kan zelf de grootte en het symbool kiezen
#driehoek 1 input:
grootte_driehoek1 = int(input("Geef de grootte van de driehoek ik: "))
symbool_driehoek1 = input("Geef het symbool in: ")
#vierkant input:
rijen_rechthoek = int(input("Geef het aantal rijen van het rechthoek in: "))
kolommen_rechthoek = int(input("Geef het aantal kolommen van de rechthoek in: "))
symbool_rechthoek = input("Geef het symbool voor de rechthoek in: ")
#driehoek 2 input:
grootte_driehoek2 = int(input("Geef de grootte van de driehoek ik: "))
symbool_driehoek2 = input("Geef het symbool in: ")
#driehoek 1:
for rij in range(1, grootte_driehoek1 + 1):
    for kolom in range(rij):
        print(symbool_driehoek1, '\t', end="")
    print()
print()
#vierkant:
for i in range(rijen_rechthoek):
    for j in range(kolommen_rechthoek):
        print(symbool_rechthoek, '\t', end="")
    print()
print()
#driehoek 2:
for rij in range(grootte_driehoek2, 0, -1):
    for kolom in range(rij):
        print(symbool_driehoek2, '\t', end="")
    print()