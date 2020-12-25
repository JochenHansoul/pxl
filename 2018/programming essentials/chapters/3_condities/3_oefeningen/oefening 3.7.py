examen1 = int(input("Resultaat eerste examen: "))
examen2 = int(input("Resultaat tweede examen: "))
examen3 = int(input("Resultaat derde examen: "))
resultaat = (examen1 + examen2 + examen3) / 0.6
if resultaat <= 60:
        print("onvoldoende")
elif resultaat <= 70:
        print("voldoende")
elif resultaat <= 80:
        print("onderscheiding")
elif resultaat <= 90:
        print("onderscheiding")
else:
        print("grootste onderscheiding")