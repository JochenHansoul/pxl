leeftijd = int(input("Geef uw leeftijd in: "))
#jaren_aansluitend = int(input("Geef het aantal aansluitende jaren in: "))
HUIDIG_JAAR = 2018
jaren_aansluitend = HUIDIG_JAAR - int(input("Geef het aansluitingsjaar in: "))
basisbedrag = float(100)
if leeftijd < 21 or leeftijd > 60:
    basisbedrag -= 14.5
basisbedrag = basisbedrag - 2.5 * jaren_aansluitend
if basisbedrag < 62.5:
    basisbedrag = 62.5
print("Uw bedrag is:", basisbedrag)