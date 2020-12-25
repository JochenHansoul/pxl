zin = "dit is een lange zin"
for i in range(len(zin)):
    if zin[i] in "aeiou":
        print("letter", zin[i], "staat op index", i)
print()
# dit werkt maar weet niet hoe goed
zin2 = "Dit is een tweede zin"
for klinker in"aeiou":
    teller = 1
    while teller != 0:
        teller = zin2.find(klinker, teller) + 1
        if teller > 0:
            print(klinker, "staat op positie", teller)
