# zie oefening 2.9
list_munten = [200, 100, 50, 20, 10, 5, 2, 1]
list_naam = ["2 euro", "1 euro", "50 cent", "20 cent", "10 cent", "5 cent", "2 cent", "1 cent"]
list_aantal = []
bedrag = int(input("Geef het bedrag in centen in: "))
for munt in list_munten:
    list_aantal.append(bedrag // munt)
    bedrag = bedrag % munt
# print(list_aantal)
for i in range(len(list_naam)):
    if list_aantal[i] != 0:
        print(list_aantal[i], "munt van", list_naam[i])
