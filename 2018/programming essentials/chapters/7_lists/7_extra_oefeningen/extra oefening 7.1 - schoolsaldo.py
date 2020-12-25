klascode = input("Geef de klascode in: ")
voorschot = int(input("Geef het voorschot in: "))
aantal_studenten = int(input("Geef het aantal studenten in: "))
list_onkosten = aantal_studenten * [0]
studentennummer = int(input("Geef het studentennummer in: "))
while studentennummer < 0 or studentennummer > aantal_studenten:
    studentennummer = int(input("Geef het studentennummer in: "))
while studentennummer != 0:
    list_onkosten[studentennummer - 1] += int(input("Geef de onkosten in: "))
    studentennummer = int(input("Geef het studentennummer in: "))
    while studentennummer < 0 or studentennummer > aantal_studenten:
        studentennummer = int(input("Geef het studentennummer in: "))
for i in range(len(list_onkosten)):
    print(klascode, i + 1, list_onkosten[i], list_onkosten[i] - voorschot)