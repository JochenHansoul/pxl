# Hansoul Jochen - 1TIN C
# 0:S/A - 1:omschrijving - 2:aantal bijbesteld (alleen S) - 3: S:minstens in voorraad, A:laatste telling
def afdrukken_bijbestellen(list_bij_bestellen):
    print("\nLijst van de bij te bestellen producten")
    for i in range(len(list_bij_bestellen[0])):
        print("product", list_bij_bestellen[0][i], "te bestellen:", list_bij_bestellen[1][i], "stuks")


def afdrukken_actie(list_actie):
    print("\nLijst van de actie artikelen")
    for i in range(len(list_actie[0])):
        print(list_actie[0][i] + "-" + str(list_actie[1][i]))


list_ruw = ["S-kaftE34-5-100", "S-DVD345-1-124", "A-penD34-125","S-boekX33-3-256", "A-bal34-145", "S-boekZ34-2-26", "A-ballon34-15"]
list_artikels = len(list_ruw) * []
for i in range(len(list_ruw)):
    list_artikels.append(list_ruw[i].split("-"))
    if list_artikels[i][0] == "A":
        list_artikels[i].append(list_artikels[i][2])
        list_artikels[i][2] = "0" # moet dit?

voorraad = 0
list_bij_bestellen = [[], []]
list_actie = [[], []]
for i in range(len(list_artikels)):
    print("geef het aantal artikels in voorraad van het artikel", list_ruw[i], "", end="")
    voorraad = int(input())
    while list_artikels[i][0] == "A" and voorraad > int(list_artikels[i][3]):
        print("Foute ingave! Zoveel artikels kunnen niet in voorraad zijn.\nOpnieuw: Geef het aantal artikels in voorraad van het artikel", list_ruw[i], "", end="")
        voorraad = int(input())
    if list_artikels[i][0] == "S" and voorraad < int(list_artikels[i][3]):
        list_bij_bestellen[0].append(list_ruw[i])
        list_bij_bestellen[1].append(int(list_artikels[i][3]) - voorraad)
        #if list_bij_bestellen[1][i] % int(list_artikels[i][3]) > 0:
         #   list_bij_bestellen[1][i] += list_bij_bestellen[1][i] % int(list_artikels[i][3])
    if list_artikels[i][0] == "A":
        list_actie[0].append(list_artikels[i][0] + "-" + list_artikels[i][1])
        list_actie[1].append(voorraad)
afdrukken_bijbestellen(list_bij_bestellen)
afdrukken_actie(list_actie)