zin = input("Geef een zin in: ")
teken = input("Geef een teken in: ")
for letter in "aeuoi":
    zin = zin.replace(letter, teken)
print(zin)