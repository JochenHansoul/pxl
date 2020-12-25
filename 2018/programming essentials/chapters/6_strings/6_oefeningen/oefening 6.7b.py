from random import randint


def encryptie(zin, getal):
    nieuw = ""
    for letter in zin:
        nieuw += chr(ord(letter) + getal)
    return nieuw


zin = input("Geef een zin in: ")
random_getal = randint(1, 12) * 2
nieuw = encryptie(zin, random_getal)
print(nieuw)