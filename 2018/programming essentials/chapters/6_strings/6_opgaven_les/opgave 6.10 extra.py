# tekst omzetten naar hoofdletters zonder
# gebruik te maken van de methode upper
tekst = input("geef een tekst in")
nieuw = ""
for letter in tekst:
    if letter.islower():
        nieuw += chr(ord(letter) - 32) # voor grote letter kleine letter te maken
    else:
        nieuw += letter
print(nieuw)