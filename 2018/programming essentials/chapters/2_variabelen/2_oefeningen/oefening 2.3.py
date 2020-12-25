#Extra afgekapt op 1 decimaal

lengte = float(input("Geef uw lengte in m in: "))
gewicht = float(input("geef uw gewicht in Kg in: "))

bmi = gewicht / (lengte * lengte)
bmi = int(bmi * 10) / 10
#deze minder goed?: bmi = bmi * 10 // 1 / 10

print("Uw BMI is", bmi)
