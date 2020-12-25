from random import randint
def cumultative_sum(list):
    for i in range(1, len(list)):
        list[i] = list[i] + list[i - 1] # geen return nodig, de lijst wordt zelf vernieuwd


lijst = []
for i in range(100):
    getal = randint(1, 9)
    lijst.append(getal)
print(lijst)
cumultative_sum(lijst)
print(lijst)

lijst_letter = []
for i in range(10):
    letter = chr(randint(ord("a"), ord("z")))
    lijst_letter.append(letter)
print(lijst_letter)
cumultative_sum(lijst_letter)
print(lijst_letter)