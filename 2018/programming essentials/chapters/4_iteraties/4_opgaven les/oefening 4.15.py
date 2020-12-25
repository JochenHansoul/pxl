#Geef reeks getallen in
#stop de berekenig als ingegeven getal deelbaar is door 5
#van elk ingegeven getal nagaan of deelbaar door 2
#=> getal x is deelbaar door 2

getal = int(input("Geef een getal in: "))
while getal % 5 != 0:
    if getal % 2 == 0:
        print("Getal", getal, "is deelbaar door 2.")
    getal = int(input("Geef een getal in: "))