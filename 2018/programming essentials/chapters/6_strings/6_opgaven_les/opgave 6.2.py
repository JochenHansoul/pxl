tekst ="Dit is een tekst met een heleboel klinkers in"
for i in range(len(tekst)):
    if tekst[i] in "aeiou":
        print(tekst[i], "bevind zich op index", i)
print()
print()

# dit is minder goed
teller = 0
for letter in tekst:
    teller += 1
    if letter in "aeiou":
        print(letter, "bevind zich op index", teller -1)