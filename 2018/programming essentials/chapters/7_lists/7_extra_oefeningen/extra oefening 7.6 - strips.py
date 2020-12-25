lists_strips = [["De chninkel", "Vanhamme"],
                ["Kuifje in Tibet", "Herge"],
                ["Maus", "Spiegelman"],
                ["Kuifje en de blauwe lotus", "Herge"],
                ["Largo Winch: de erfgenamen", "Vanhamme"]]
list_geliefd = [[105, 35, 5],
                [66, 21, 12],
                [150, 36, 56],
                [56, 12, 12],
                [29, 10, 9]]
hoogste_som = 0
for i in range(len(lists_strips)):
    som = sum(list_geliefd[i])
    print(lists_strips[i], som)
    if som > hoogste_som:
        hoogste = i
        hoogste_som = som
print("de strip met het hoogst aantal stemmen is", lists_strips[hoogste][0].upper(), "van auteur", lists_strips[hoogste][1].upper())