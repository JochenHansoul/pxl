def ber_punten(vragen, juist):
    score = 20
    for i in range(10):
        if vragen[i] == "E":
            score += 0
        elif vragen[i] == juist[i]:
            score += 2
        else:
            score -= 1
        return score


def ber_geboortedatum(geboren, huidig):
    list_geboren = geboren.split("/")
    list_huidig = huidig.split("/")
    leeftijd = int(list_huidig[2]) - int(list_geboren[2])
    if int(list_geboren[1]) > int(list_huidig[1]) or list_geboren[0] >= list_huidig[0] and list_geboren[1] == list_huidig[1]:
        leeftijd += 1
    return leeftijd


huidige_datum = input("Geef de datum van vandaag in vb. 10/12/2018: ")
juiste_antwoorden = input("Geef de 10 juiste antwoorden in (ABCD):  ")
list_deelnemers = []
invoer = input("Geef de data in (deelnemernummer, geboortedatum, 10 antwoorden ABCDEF, (E blanco), tijd in sec.: ")
teller = 0
while invoer != "0":
    list_deelnemers.append(invoer.split(" "))
    list_deelnemers[teller][2] = str(ber_punten(list_deelnemers[teller][2], juiste_antwoorden))
    list_deelnemers[teller][1] = str(ber_geboortedatum(list_deelnemers[teller][1], huidige_datum))
    seconden = int(list_deelnemers[teller][3])
    uren = seconden // 3600
    seconden %= 3600
    minuten = seconden // 60
    if seconden > 30:
        minuten += 1
    list_deelnemers[teller][3] = str(uren) + "u", str(minuten) + "m"
    teller += 1
    print(list_deelnemers)
    invoer = input("Geef de data in (deelnemernummer, geboortedatum, 10 antwoorden ABCDEF, (E blanco), tijd in sec.: ")
for i in range(len(list_deelnemers)):
    print(list_deelnemers[i][0], list_deelnemers[i][1], list_deelnemers[i][2], list_deelnemers[i][3], "ptn")