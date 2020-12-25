# Schrijf een functie genereer_tekst(n).
# Hierbij is n het aantal tekens dat de tekst moet bevatten, de tekst bevat alleen de hoofdletters van het alfabet.
from random import randint
def genereer_tekst(n):
    text = ""
    for i in range(n):
        getal = randint(65, 90)
        text += chr(getal)
    return text


n = int(input("Geef een getal in: "))
text = genereer_tekst(n)
print(text)