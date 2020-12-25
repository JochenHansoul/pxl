#zie extra opgave 3 uit H4
#maak een functie om een driehoek te maken, grootte is variabel
#functie die de som van de getallen uit zo'n driehoek bereknt
def print_driehoek(grootte):
    for rij in range(1, 6):
        for kolom in range(1, grootte + 1):
            for kolom in range(1, grootte + 2 - rij):
                print(kolom, "\t", end="")
            print()

def bereken_som(grootte):
    som = 0
    for rij in range(1, grootte + 1):
        for kolom in range(1, grootte + 2 - rij):
            som = som + kolom
    return som

print_driehoek(15)
totaal = bereken_som(15)
print_driehoek("De som van de getalle nvan een driehoek van grootte 15 is", totaal)