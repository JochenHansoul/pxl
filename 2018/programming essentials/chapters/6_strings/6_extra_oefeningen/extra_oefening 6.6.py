# Schrijf een functie om in een zin elke klinker te vervangen door een teken.
# Test je methode uit door een zin en een teken in te geven via het toetsenbord.
zin = input("Geef een zin in: ")
teken = input("Geef een teken in: ")
zin = zin.replace("a", teken).replace("e", teken).replace("o", teken).replace("u", teken).replace("i", teken)
print(zin)