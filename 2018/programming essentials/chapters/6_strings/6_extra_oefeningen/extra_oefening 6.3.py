# Schrijf een functie keer_om_n(tekst, n) met als output
# een string waarbij de letters van de string in omgekeerde volgorde voorkomen en elke letter n keer herhaald werd
def keer_om_n(tekst, n):
    tekst = tekst[-1::-1]
    nieuw = ""
    for letter in tekst:
        for i in range(n):
            nieuw += letter
    return nieuw


string = input("Geef een string in: ")
n = int(input("Geef een getal in: "))
nieuw = keer_om_n(string, n)
print(nieuw)