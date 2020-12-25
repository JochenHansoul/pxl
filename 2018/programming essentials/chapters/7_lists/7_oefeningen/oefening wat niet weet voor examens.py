def bereken_leeftijd(gebdatum, hdatum):
    lijst_gebdatum = gebdatum.split("/")
    leeftijd = int(hdatum[2]) - int(lijst_gebdatum[2])
    if int(lijst_gebdatum[1]) > int(hdatum[1]) or int(lijst_gebdatum[1]) == int(hdatum[1]) and int(lijst_gebdatum[0]) > int(hdatum[0]):
        leeftijd -= 1
    return leeftijd


def zet_om_sec(sec):
    uren = sec // 3600
    sec = sec % 3600
    min = sec // 60
    sec = sec % 60
    if sec >= 30:
        min += 1
        if min == 60:
            uren += 1
            min = 0
    return str(uren) + "  " + str(min) + "m"


def bereken_punten(juist, antwoord):
    punten = 20
    for i in range (len(antwoord)):
        if antwoord[i] == juist[i]:
            punten += 2
        elif antwoord[i] != "E": # E is blijkbaar het nummer voor een blanco antwoord
            punten -= 1
    return punten


output = []
huidige_datum = input("Geef de huidige datum in d/m/j: ")
vandaag = huidige_datum.split("/")
juist = input("geef de juiste antwoorden in:")
gegevens = input("geef de gegevens v/e deelnemer in")
teller = 0
while gegevens != "0":
    teller += 1
    lijst_gegevens = gegevens.split(" ")
    leeftijd = bereken_leeftijd(lijst_gegevens[1], vandaag)
    tijd = zet_om_sec(lijst_gegevens[3])
    punten = bereken_punten(juist, lijst_gegevens[2])
    output.append(str(teller) + ".\t" + lijst_gegevens[0] + "\t" + str(leeftijd) + "jaar" + "\t" + str(punten) + "punt")
    gegevens = input("geef de gegevens v/e deelnemer in: ")
for lijn in output:
    print(lijn)