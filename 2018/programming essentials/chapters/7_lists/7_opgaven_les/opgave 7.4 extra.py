# genereer 100 getallen >- 5  en < 15
# Hoeveel getallen wijken maximaal 2 af van het gemiddelde
from random import randint
list = []
som = 0
for i in range(100):
    list.append(randint(-4, 14))
    som += list[i]
gemiddelde = som / 100
teller = 0
for getal in list:
    if getal >= gemiddelde -2 and getal <= gemiddelde + 2:
        teller += 1
print(gemiddelde)
print("Het aantal getallen dat maximaal 2 afwijkt van gemiddelde", teller)