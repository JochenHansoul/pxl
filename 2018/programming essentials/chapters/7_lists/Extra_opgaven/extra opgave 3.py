# genereer 2489 gehele getallen >= 0 en <= 6
# ga na dat elk getal ongeveer even vaak voorkomt
# druk het procentueel aandeel van elk getal af.
# gewoon het op deze manier doen    getal = 0   tel[0] += 1
#                                   getal = 1   tel[1] += 1
from random import randint
weekdagen = ["maandag", "dinsdag", "woensdag", "donderdag", "vrijdag", "zaterdag", "zondag"]
list_tel = 7 * [0]
print(list_tel)
for i in range(2489):
    getal = randint(0, 6)
    list_tel[getal] += 1
for getal in range(7):
    # print("procentueel aandeel van getal", getal, "is", list_tel[getal] / 2489 * 100)
    print("Procentueel aandeel van {} is {:.2f}".format(weekdagen[getal], list_tel[getal] / 2489 * 100))


# 0 => maandag; 1 => dinsdag; ...
# De dagen moeten ook afgedrukt woren.

# een lus aanmaken met weekdagen, liefst zonder gebruikt te maken van if
# stoppen in array

