list = []
getal = int(input("Geef een getal in, 0 om te eindigen: "))
while getal != 0:
    if getal not in list:
        list.append(getal)
    else:
        print(getal, "komt voor op plaats", list.index(getal))
        list.remove(getal)
    getal = int(input("Geef een getal in, 0 om te eindigen: "))
print(list)