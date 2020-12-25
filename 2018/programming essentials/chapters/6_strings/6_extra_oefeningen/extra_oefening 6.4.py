# Maak een functie sorteer om de letters in een tekst alfabetisch (enkel kleine letters) te rangschikken.
# sorteer(“abdaba”) geeft als output aaabbd.
# 97a, 122z
def sorteer(tekst):
    nieuw = ""
    begin_alfabet = ord("a")
    for i in range(26):
        for letter in tekst:
            if ord(letter) == begin_alfabet + i:
                nieuw += letter
    return nieuw


tekst = input("Geef een tekst in: ")
nieuw = sorteer(tekst)
print(nieuw)