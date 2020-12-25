apestaart = "@"
aantal = int(input("Geef het aantal apenstaarten in: "))
for i in range(aantal):
    for j in range(aantal - i):
        print(apestaart, end="")
    print()