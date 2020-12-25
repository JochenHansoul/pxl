vertrek_uur = int(input("Geef het vertrek uur in: "))
vertrek_minuut = int(input("Geef het vertrekminuut in: "))
tijd = int(input("Geef de tijd van de vlucht in, in minuten: "))

print("Aankomst uur: ", (vertrek_uur + (vertrek_minuut + tijd) // 60) % 24)
print("Aankomst minuut: ", (vertrek_minuut + tijd) % 60)
print("duur: ", tijd)
