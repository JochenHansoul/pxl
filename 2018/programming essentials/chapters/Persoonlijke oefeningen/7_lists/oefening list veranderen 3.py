geboren = "11/05/1990"
huidig = "10/12/2018"
list_geboren = geboren.split("/")
list_huidig = huidig.split("/")
leeftijd = int(list_huidig[2]) - int(list_geboren[2])
if list_geboren[1] > list_huidig[1] or list_geboren[0] >= list_huidig[0] and list_geboren[1] == list_huidig[1]:
    leeftijd += 1
print(leeftijd)