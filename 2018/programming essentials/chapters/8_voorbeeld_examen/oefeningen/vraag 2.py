from random import randint


aantal = int(input("Hoeveel gehele getallen nodig?: "))
while aantal < 0:
    aantal = int(input("geef een positief geheel getal in groter dan nul: "))
veelvoud_getal = int(input("Geef een veelvoudgetal in: "))
while veelvoud_getal > 10: # hier moest ook een controle groter dan 0 op komen natuurlijk
    veelvoud_getal = int(input("Geef een veelvoudgetal kleiner dan 10 in: "))
list = []
som = 0
for i in range(aantal):
    x = randint(1, 10) * veelvoud_getal # is dit goed of moet het echt in range 1 - 100 zijn?
    list.append(x)
    som += x
gem = som / aantal
if aantal % 2 != 0:
    print(list[-1::-1])
else:
    print(list)
list_klein = []
for i in range(aantal):
    if list[i] < gem:
        list_klein.append(list[i])
print(list_klein)