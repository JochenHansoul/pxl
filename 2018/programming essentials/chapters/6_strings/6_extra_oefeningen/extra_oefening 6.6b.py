# Deze oplossing lijkt me ook niet goed
zin = input("Geef een zin in: ")
teken = input("Geef een teken in: ")
nieuw = ""
for letter in zin:
    if letter in "aeuoi":
        nieuw += teken
    else:
        nieuw += letter
print(nieuw)