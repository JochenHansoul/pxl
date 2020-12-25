# Schrijf een programma om een tekst waarvan het aantal letters deelbaar is door 3 om te zetten naar hoofdletters,
# als het aantal letters niet deelbaar is door 3 moet de tekst omgezet worden naar kleine letters.
text = input("Geef een text in: ")
if len(text) % 3 == 0:
    text = text.upper()
else:
    text = text.lower()
print(text)