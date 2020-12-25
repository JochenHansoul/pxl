temp = int(input("Geef de temperatuur in: "))
gem_temp = temp
max_temp = temp #Ze heeft de max_temp gelijk gezet aan de temperatuur!
for i in range(9):
    temp = int(input("Geef de temperatuur in: "))
    if temp > max_temp:
        max_temp = temp
    gem_temp += temp
print("De gemiddelde temperatuur is", gem_temp / 10, "en de hoogst gemeten temperatuur is", max_temp)