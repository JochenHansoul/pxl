from random import randint
def tel_index_list(list, element):
    teller = list.count(element)
    print(element, "komt", teller, "keer voor")
    positie = -1 # (het vertrekt vanaf 0 maar er wordt in de berekening zelf +1 opgeteld) ik ga in mijn lijst opzoek naar mijn positie 1, zie onder
    for i in range(teller):
        positie = list.index(element, positie + 1)
        print("op index", positie)


lijst = []
for i in range(100):
    getal = randint(0, 9)
    lijst.append(getal)
invoer = int(input("geef een getal >=0 en <=10 in"))
while invoer > 9 or invoer < 0: # not (invoer >= 0 and in
    invoer = int(input("geef een getal >= 0 en <= 10 in "))
tel_index_list(lijst, invoer)