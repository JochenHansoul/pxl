def teken_afprinten(teken, aantal):
    #print(teken * int(aantal)) Dit is toch niet echt de manier om het te berekenen voor aan analist.
    for i in range(aantal):
        print(teken, end="")
    print()


teken1 = input("Geef een teken in: ")
aantal1 = int(input("Geef het aantal in: "))
teken_afprinten(teken1, aantal1)
#als ge bijvoorbeeld twee regels krijgt wordt het moeilijker
#vb. b:
#print_regel(5, "*")
#print_regel(15, "&")


#functie voor een rechthoek:
#def print_rechthoek(hoogte, breedte, teken):
#    for rij in range(hoogte):
#        print_regel(breedte, teken)


#volgens de codeconventies 2 regels tussen elke functie plaatsen
#print_rechthoek(5, 10, "+")