list_deelnemers = []
invoer = "100 11/05/1990 AAABBBCCCD 50000"
for i in range(3):
    list_deelnemers.append(["", "", "", ""])
    list_deelnemers[i] = invoer.split(" ")
    list_deelnemers[i][i] = "1"
    print(list_deelnemers[i])
