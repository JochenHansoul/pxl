naam = input("Geef de naam van de student in: ")
percentage = int(input("Geef het percentage in: "))
while percentage < 0 or percentage > 100:
    if percentage < 0:
        print("Fout! Het getal moet minstens 0 zijn")
    else:
        print("Fout! Het getal mag maximum 100 zijn.")
    percentage = int(input("Geef het percentage in: "))
if percentage < 60:
    print("Onvoldoende")
elif percentage < 70:
    print("voldoende")
elif percentage < 80:
    print("onderscheiding")
elif percentage < 85:
    print("Grote onderscheiding")
else:
    print("grootste onderscheiding")