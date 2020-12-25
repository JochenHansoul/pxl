from random import randint

# >= en <= 10
getal = randint(0, 10)
print(getal)
print()

# 10 getallen >0 en <10
for i in range(10):
    getal = randint(1, 9)
    print(getal)
print()

# getal >=-200 en <=1000 veelvoud van 10
for i in range(10):
    getal = randint(-20, 100) * 10
    print(getal)
print()

# >0 en <100 met juist 1 decimaal
# ge start altijd met >= 0.1 en <=99.9
for i in range(10):
    getal = randint(1, 999) / 10
    print(getal)