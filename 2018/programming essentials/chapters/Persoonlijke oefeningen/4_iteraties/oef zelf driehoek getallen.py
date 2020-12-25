teller = 0
getal = 0
grootte_driehoek = int(input("Geef de grootte van de driehoek in: "))
for vertikaal in range(grootte_driehoek):
    for horizontaal in range(grootte_driehoek - vertikaal):
        print(horizontaal + 1 + getal, "\t", end="")
    print()
    getal += (grootte_driehoek - vertikaal)