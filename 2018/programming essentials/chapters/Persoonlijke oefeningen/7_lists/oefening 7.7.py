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


juiste_antwoorden = "AAABBBCCCD"
list_deelnemers = []
invoer = "100 11/05/1990 AAABBBCCCD 50000"
teller = 0
while invoer != 0:
    list_deelnemers.append(invoer.split(" "))
    print(list_deelnemers)
    list_deelnemers[teller][2] = str(ber_punten(list_deelnemers[teller][2], juiste_antwoorden))
    print(list_deelnemers)
    teller += 1
    invoer = input("Geef de data in (deelnemernummer, geboortedatum, 10 antwoorden ABCDEF, (E blanco), tijd in sec.: ")
