tekst = input("Geef een tekst in: ")
if len(tekst) % 2 == 0:
    midden = len(tekst) // 2 - 1    # het moet een gehele deling zijn '//' want anders maakt hij daar een float van!
    deel2 = tekst[midden:midden + 2]
    deel3 = tekst[midden + 2:] #de : betekend tot het einde
else:
    midden = len(tekst) // 2
    deel2 = tekst[midden]
    deel3 = tekst[midden + 1:]
deel1 = tekst[0:midden]
nieuw = deel1 + deel2.upper() + deel3
print(nieuw)

#dubbele code, serieus aantal punten van examen!