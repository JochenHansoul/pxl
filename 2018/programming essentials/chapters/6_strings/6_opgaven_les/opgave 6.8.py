spreuk = "abracadabra"
spreuk = spreuk.replace("a" , "o")
print(spreuk)
# tel nu al de o's
# methode 1
print(spreuk.count("o")) #je mag de methode count niet gebruiken tenzij het erbij staat!
# methode2 mbv methode find
positie = spreuk.find("o")
teller = 0
while positie != -1:
    teller += 1
    positie = spreuk.find("o", positie + 1)
print(teller)
# methode 3  (minst goede manier, hier gaat ge elke letter af en is niet geschikt voor lange teksten)
for i in range(len(spreuk)):
    if spreuk[i] == "o":
        teller += 1
print(teller)