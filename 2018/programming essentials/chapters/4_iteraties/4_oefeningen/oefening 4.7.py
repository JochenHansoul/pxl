gem_temp = 0
hoogste_temp = -100
for i in range(10):
    temp = int(input("Geef de temperatuur in: "))
    gem_temp += temp
    if hoogste_temp < temp:
        hoogste_temperatuur = temp
print("De gemiddelde temperatuur is", gem_temp / 10, "en de hoogst gemeten temperatuur is", hoogste_temp)