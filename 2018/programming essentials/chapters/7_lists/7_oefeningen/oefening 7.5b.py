# code 1: An Janssen
# code 2: Bart Vriends
# code 3: Andries Michels
# code 4: Inge Kaas
list_namen = [" ","An Janssens", "Bart Vriends", "Andries Michels", "Inge Klaas"] # ze maakt de lists efficienter door er 5 plaatsen aan te geven
list_stemmen = 5 * [0]
code = int(input("Geef een code in: "))
while code != 0:
    list_stemmen[code] += 1
    code = int(input("Geef een code in: "))
totaal_stemmen = sum(list_stemmen)
for i in range(1,5): # drukt dan af van 1 - 5
    print(list_namen[i], "stemmen:", list_stemmen[i], str(int(list_stemmen[i] / totaal_stemmen * 1000) / 10) + "%")