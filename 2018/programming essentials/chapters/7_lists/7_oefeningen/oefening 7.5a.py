# code 1: An Janssen
# code 2: Bart Vriends
# code 3: Andries Michels
# code 4: Inge Kaas
list_namen = ["An Janssens", "Bart Vriends", "Andries Michels", "Inge Klaas"]
list_stemmen = 4 * [0]
totaal_stemmen = 0
code = int(input("Geef een code in: "))
while code != 0:
    list_stemmen[code - 1] += 1
    totaal_stemmen += 1
    code = int(input("Geef de code in voor wie u wilt stemmen (1 - 4): "))
for i in range(4):
    print(list_namen[i], "stemmen:", list_stemmen[i], str(int(list_stemmen[i] / totaal_stemmen * 1000) / 10) + "%")