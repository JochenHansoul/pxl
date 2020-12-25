def get_number_of_participants(list):
    return len(list[0]) # dit is dan de eerste list


def get_number_of_test(list):
    return len(list)


def highest_heart_rate(list):
    grootste = list[0][0]
    for i in range(len(list)):
        for j in range(len(list[i])):
            if grootste < list[i][j]:
                grootste = list[i][j]
    return grootste


def lowest_heart_rate(list):
    kleinste = list[0][0]
    for i in range(len(list)):
        klrij = min(list[i])
        if kleinste > klrij:
            kleinste = klrij
    return kleinste


def average_heartrate(list): # De gemiddelde hartslag per persoon berekenen
    average = []
    for i in range(len(list)):
        som = sum(list[i])
        average.append(som / len(list[i]))
    return average


def heart_range_difference(list): # opnieuw per deelnemer
    difference = []
    for j in range(len(list[0])): # die hebt ge altijd!
        kl = list[0][j]
        gr = list[0][j] # nu ga ik in de rest van de rijen kijken of daar een groter element staat of kleiner, het gaat toch elke kolom vertikaal af.
        for i in range(1, len(list)):
            if list[i][j] > gr:
                gr = list[i][j]
            elif list[i][j] < kl:
                kl = list[i][j]
        difference.append(gr - kl)
    return difference



list = [[72, 75, 73, 72, 76],
        [91, 90, 94, 93, 88, 91],
        [130, 135, 139, 142, 129, 138],
        [120, 118, 110, 105, 121, 119]]
print("aantal deelnemers:", get_number_of_test(list))
print("aantal testen:", get_number_of_test(list))
print("De grootste hartslag is:", highest_heart_rate(list))
print("De kleinste hartslag is", lowest_heart_rate(list))
print("De gemiddelde hartslag per persoon is:", average_heartrate(list))
print("Het verschil in hartslag per deelnemer is", heart_range_difference(list))