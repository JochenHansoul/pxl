text = input("Geef een tekst in: ")
letter_t = text.lower().find("t")
if letter_t == -1:
    print("Er staat geen letter t of T in.")
else:
    deel1 = text[:letter_t]
    if len(text) % 2 == 0:
        deel2 = text[letter_t:].lower()
    else:
        deel2 = text[letter_t:].upper()
    nieuw = deel1 + deel2
    print(nieuw)