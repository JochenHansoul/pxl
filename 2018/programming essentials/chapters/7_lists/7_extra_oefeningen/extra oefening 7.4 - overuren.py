"""
personeelsnummer
uurloon
gewerke uren per week
    invoer stopt als personeelsnummer 0

lijst werknemer:
        personeelsnummer
        weekloon (functie)
        terug vorderen uren (functie)
"""
UREN_DAG = 38
def bereken_weekloon(uurloon, gewerkte_uren, dag):
    if gewerkte_uren <= 38:
        return uurloon * dag
    elif gewerkte_uren < 48:
        return uurloon * 38 + uurloon * (gewerkte_uren - dag) * 1.5
    elif gewerkte_uren < 53:
        return uurloon * 38 + uurloon * 10 * 1.5 + uurloon * (gewerkte_uren - dag - 10) * 2
    else:
        return uurloon * 38 + uurloon * 10 * 1.5 + uurloon * 5 * 2 + uurloon * (gewerkte_uren - dag - 10 - 5) * 1.2


def uren_berekenen(uren, dag):
    terug_uren = uren - dag - 10 - 5
    if terug_uren > 0:
        return terug_uren
    else:
        return 0


list_persnummer = []
list_uurloon = []
list_gewerte_uren = []
totaal_personeelsleden = 0
pers_nummer =int(input("Geef het personeelsnummer in: "))
while pers_nummer != 0:
    list_persnummer.append(pers_nummer)
    list_uurloon.append(int(input("Geef het uurloon in: ")))
    list_gewerte_uren.append(int(input("Geef het aantal uren per week gewerkt in: ")))
    pers_nummer = int(input("Geef het personeelsnummer in: "))
    totaal_personeelsleden += 1
totaal_loon = 0
totaal_terug_uren = 0
list_categorie = 5 * [0]
for i in range(len(list_persnummer)):
    weekloon = bereken_weekloon(list_uurloon[i], list_gewerte_uren[i], UREN_DAG)
    terugvord_uren = uren_berekenen(list_gewerte_uren[i], UREN_DAG)
    totaal_loon += weekloon
    totaal_terug_uren += terugvord_uren
    uren = list_gewerte_uren[i]
    if uren < 38:
        list_categorie[0] += 1
    elif uren == 38:
        list_categorie[1] += 1
    elif uren <= 48:
        list_categorie[2] += 1
    elif uren <= 53:
        list_categorie[3] += 1
    else:
        list_categorie[4] += 1
    print("Personeelsnummer:", list_persnummer[i], "Weekloon:", weekloon, "Teruggevoerderde uren:", terugvord_uren)
print("Totaal aantal personeelsleden:", totaal_personeelsleden, "totaal lonen:", totaal_loon, "Totaal teruggevorderde uren:", totaal_terug_uren)
for i in range(5):
    print("categorie", i, list_categorie[i])