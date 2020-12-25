# random getal berekend:
# het random getal moest ook 4 cijfers hebben --> randint(1000, 9999)
# while str(getal) != "0" and (getal <= 5000 or getal % 2 == 0):
list = 5 * []
teller = 0
list[teller][0] = input("Geef een getal in: ")
print(list)
while list[teller] != "0":
    list[teller][1] = 0
    list[teller][2] = "string"
    list[teller][3] = 2
    list[teller][4] = "tweede string"
    print(list)
    list.append(5 * [])
    teller += 1
    list[teller][0] = input("Geef een getal in: ")
print(list)