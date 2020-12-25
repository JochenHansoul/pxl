def ster_beeld(list):
    if int(list[0]) < 21:
        return list_sterrenbeelden[list[1] - 1] # ze heeft de list[1] in een int() gestopt, dit zou normaal niet moeten werken
    else:
        return list_sterrenbeelden[list[1]] # dit ook


def print_naam(voornaam, naam, datum_list, sterrenbeeld):
    vol_naam = voornaam[0] + "." + naam
    print(vol_naam.upper(), datum_list[0] + "/" + str(datum_list[1]), sterrenbeeld)


list_sterrenbeelden = ["steenbok", "waterman", "vissen", "ram", "stier", "tweeling", "kreeft", "leeuw", "maagd", "weegschaal", "schorpioen", "boogschutter", "steenbok"]
naam = input("Geef een naam in: ")
while naam != "/":
    voornaam = input("Geef een voornaam in: ")
    geboortedatum = input("Geef de geboortedatum in (dd/mm/yyyy: ")
    datum_list = geboortedatum.split("/")
    sterrenbeeld = ster_beeld(datum_list)
    print_naam(voornaam, naam, datum_list, sterrenbeeld)
    naam = input("Geef een naam in: ")