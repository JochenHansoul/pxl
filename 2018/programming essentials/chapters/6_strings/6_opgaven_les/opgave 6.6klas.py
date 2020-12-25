tekst = input("Geef een tekst in: ")
if len(tekst) % 2 == 0:
    midden = len(tekst) // 2 - 1    # het moet een gehele deling zijn '//' want anders maakt hij daar een float van!
    deel1 = tekst[0:midden]             # deze delen zijn hetzelfde
    deel2 = tekst[midden:midden + 2]
    deel3 = tekst[midden + 2:]      #de : betekend tot het einde.
else:
    midden = len(tekst) // 2
    deel1 = tekst[0:midden]             # deze delen zijn hetzelfde
    deel2 = tekst[midden:midden]
    deel3 = tekst[midden + 1:]
nieuw = deel1 + deel2.upper() + deel3
print(nieuw)