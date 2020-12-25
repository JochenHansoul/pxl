fruit1 = "mango"
fruit2 = "banaan"
print(fruit1, "en", fruit2, "hebben ", end="")
teller = 0
for letter in fruit1:
    teller += 1
    if letter in fruit2:
        print(letter, end="")
        if teller < len(fruit1) - 1: #Het moet niet stoppen met de laatste letter van fruit1 maar met de laatste gemeenschappelijke letter.
            print(" en ", end="")
print(" gemeen.")