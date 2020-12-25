stud1 = [12, 4, 12, 9]
stud2 = [14, 5, 9, 11]
stud3 = [8, 9, 7, 12]
stud4 = [7, 12, 11, 10]
stud5 = [11, 18, 10, 14]
# toetsenbord ingeven?
list_min = []
list_gem = []
long_list = []
list_laagste_student = []
for i in range(4):
    #list_min.append(min(stud1[i], stud2[i], stud3[i], stud4[i], stud5[i]))
    #ik ben niet blij met de volgende 5 berekeningen
    long_list.append(stud1[i])
    long_list.append(stud2[i])
    long_list.append(stud3[i])
    long_list.append(stud4[i])
    long_list.append(stud5[i])
    list_min.append(min(long_list))
    list_laagste_student.append(long_list.index(list_min[i]) + 1)
    som_punten = stud1[i] + stud2[i] + stud3[i] + stud4[i] + stud5[i]
    list_gem.append(int(som_punten / 25 * 10) / 10)
    long_list = []
print("De laatste scores van elke vak zijn", list_min)
print("De gemiddelde scores van elke vak zijn", list_gem)
print("De student die de laagste score voor het vak heeft is:", list_laagste_student)