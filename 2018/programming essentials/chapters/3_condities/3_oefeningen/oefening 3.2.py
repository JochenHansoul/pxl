brutoloon = int(input("Geef brutoloon in: "))
vakantiegeld = brutoloon / 100 * 5

if vakantiegeld >= 350:
	bijdrage = 350 / 100 * 8
else:
	bijdrage = vakantiegeld / 100 * 8

print("het brutoloon is: ", brutoloon)
print("Het vakantiegeld is: ", vakantiegeld)
print("De jaarlijkse bijdrage is: ", bijdrage)
