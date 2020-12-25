"""tekst = input("geef een woord in: ")
letters = len(tekst)
if (letters % 2) == 0:
    letter1 = letters / 2
    letter2 = letter1 + 1
    woord_hoofdletter = woord[letter1 letter2].upper()
print(woord_hoofdletter)"""

# 2e poging:
# het is wel goed denk ik maar kon beter op sommige punten
woord = "buik"
if len(woord) % 2 == 0:
    i = len(woord) // 2 # het moest een // zijn i.p.v. / !!! anders maakt hij daar een float van.
    eerste = woord[:i - 1]
    midden = woord[i - 1] + woord[i]
    laatste = woord[(i + 1):]
else:
    i = int(len(woord)) // 2
    eerste = woord[:i]
    midden = woord[i]
    laatste = woord[(i + 1):]
midden = midden.upper()
print(eerste + midden + laatste)