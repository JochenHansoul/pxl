tekst = input("geef een tekst in: ")
nieuw = " "
for letter in tekst:
    #if ord(letter) >= ord("a") and ord(letter) <= ord("z"):
    if letter.islower(): #hier wordt er getest of een letter een kleine letter is, true indien juist, false indien fout
        nieuw += letter
    else:
        nieuw += " "
print(nieuw)