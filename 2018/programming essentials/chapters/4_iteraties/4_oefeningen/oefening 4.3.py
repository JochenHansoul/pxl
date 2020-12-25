getal = int(input("geef een getal in: "))
som_getal = 0
negatieve_getallen = 0
while getal != 0:
    if getal < 0:
        negatieve_getallen += 1
    som_getal += getal
    getal = int(input("geef een getal in: "))
print("De som van al deze getallen is", som_getal, "het aantal negatieve getallen is", negatieve_getallen)