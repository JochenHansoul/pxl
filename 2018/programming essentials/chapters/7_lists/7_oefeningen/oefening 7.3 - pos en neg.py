from random import randint
getal = 0
kleinste_getal = 0
pos_list = []
neg_list = []
for i in range(10):
    getal = int(input("Geef een getal in: "))
    if getal < 0:
        neg_list.append(getal)
    else:
        pos_list.append(getal)
for i in neg_list:
    if i < kleinste_getal:
        kleinste_getal = i
print("Aantal positieve getallen:", len(pos_list), "som:", sum(pos_list))
print("aantal negatiege getallen:", len(neg_list), "som:", sum(neg_list))
if len(neg_list) != 0:
    print("Het kleinste negatieve getal is:", kleinste_getal)