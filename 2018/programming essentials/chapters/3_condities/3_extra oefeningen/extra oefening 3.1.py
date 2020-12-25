# Er worden 3 getallen ingelezen `a`, `b` en `c`.
# Als $a + b$ kleiner is dan 20, moet `c` bij deze som geteld worden.
# Als `a` en `b` samen groter dan of gelijk aan 20 zijn, dan moet de tekst *te groot* afgedrukt worden.

getala = int(input("Geef getal a in: "))
getalb = int(input("Geef getal b in: "))
getalc = int(input("geef getal c in: "))
som_ab = getala + getalb

if som_ab < 20:
    som_ab += getalc
else:
    print("te groot")