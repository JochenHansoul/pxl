def toon_tafel(getal):
    for i in range(11):
        res = i * getal #res is locale variabele, bestaat alleen als de functie wordt uitgevoerd.
        print(i, "x", getal, "=", res)


toon_tafel(15)