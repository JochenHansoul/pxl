from random import randint
aantal = int(input("Hoeveel gehele getallen nodig?: "))
while aantal < 0:
    aantal = int(input("geef een positief geheel getal in groter dan nul: "))
veelvoud_getal = int(input("Geef een veelvoudgetal in: "))
while veelvoud_getal > 10:
    veelvoud_getal = int(input("Geef een veelvoudgetal kleiner dan 10 in: "))
som = 0
list_getallen = []
for i in range(aantal):
    getal = randint(1, int(100 / veelvoud_getal)) * veelvoud_getal
    list_getallen.append(getal)
    som += getal
gem = som / aantal
if aantal % 2 != 0:
    print("De getallen in speciale afdruk zijn:")
    print(list_getallen[-1::-1]) # print(lijst_getal) --> deze output is niet goed, zie output opgave!
else:
    print("De gegenereerde getallen zijn:")
    print(list_getallen)
print("De getallen kleiner dan het gemiddelde zijn:")
for i in range(aantal):
    if list_getallen[i] < gem:
        print(list_getallen[i], "", end="")