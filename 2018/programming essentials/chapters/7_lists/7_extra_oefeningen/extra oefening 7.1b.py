invoer = input("Geef de klascode, betaalde voorschot, aantal studenten en rest in in gescheiden door spaties: ")
list = invoer.split(" ")
klascode = list[0]
voorschot = list[1]
aantal_studenten = int(list[2])
totaal_voorschot = voorschot * aantal_studenten
list_onkosten = aantal_studenten * [0]
st_nummer = int(input("Geef nummer student in: "))
teller = 4
while st_nummer != 0:
    while st_nummer < 0 or st_nummer > aantal_studenten:
        st_nummer = int(input("Geef nummer student in: "))
    list_onkosten[st_nummer] += list[teller]
    st_nummer = int(input("Geef nummer student in: "))
print(list_onkosten)