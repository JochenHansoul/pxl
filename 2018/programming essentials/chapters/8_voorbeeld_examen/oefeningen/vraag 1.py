def weerbericht_uitprinten(list_temp, list_neerslag):
    print("dag", "\t", "temperatuur", "\t",  "\t", "neerslag")
    for i in range(len(list_neerslag)):
        print(i + 1, "\t",  "\t", list_temp[i],  "\t",  "\t", "\t", "\t", list_neerslag[i])


x = 0
gem_temp = 0
list_temp = []
list_neerslag = []
while x < 7:
    temp = int(input("Geef de temperatuur in: "))
    neerslag = input("Geef de hoeveelheid neerslag (overvloedig, veel, matig, geen): ")
    gem_temp += temp
    list_temp.append(temp)
    list_neerslag.append(neerslag)
    if neerslag != "overvloedig":
        x += 3
    else:
        x = 7
gem_temp /= len(list_neerslag)
# hier wordt gekeken of er "veel" in de list_temp staat
# deze tweede lus is eigenlijk overbodig en kan net zo goed in de eerste lus staan, if neerslag == "veel": veel_neerslag = 1
veel_neerslag = 0
for i in range(len(list_neerslag)):
    if list_temp[i] == "veel":
        veel_neerslag = 1
# printen
# de functie voor het uitprinten kon gewoon bovenaan staan (hier bevoorbeeld) en moest niet in een functie staan
if len(list_neerslag) < 7:
    print(weerbericht_uitprinten(list_temp, list_neerslag), "Er wordt niet op uitstap gegaan door overvloedig regen")
else:
    if min(list_temp) < 15 or min(list_temp) < 0.2 * gem_temp or veel_neerslag != 0:
        weerbericht_uitprinten(list_temp, list_neerslag)
        print("\tEr wordt een ééndaagse uitstap gegaan: ")
    else:
        print(weerbericht_uitprinten(list_temp, list_neerslag), "Er wordt een 2daagse uitstap gedaan")