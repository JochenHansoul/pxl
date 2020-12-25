# Maak een programma om een prijsofferte van een garagepoort te maken. Geef naast de naam van de verkoper, de hoogte en de breedte van de poort in meter in.
# Daarnaast moet ingegeven worden of men een speciale kleur wenst of niet. Op basis van deze gegevens wordt een prijsofferte gemaakt.
# De prijsofferte bevat naast een offertenummer, de oppervlakte van de poort, het gewicht van de poort, het type motor en de totaalprijs van de poort.
# Hou rekening met het volgende:
# + De poort is minimaal 2m hoog en maximaal 6,5m hoog. Maak een methode om te controleren of de opgegeven hoogte correct is. Zolang geen correcte hoogte wordt opgegeven,
# blijf je de gebruiker voor een geldige hoogte van de garagepoort vragen.
# + Doe hetzelfde voor de input van de breedte van de garagepoort. De minimale breedte is 2m, de maximale breedte is 8m.
# + Maak een methode om de oppervlakte van de poort te berekenen.
# + Maak een methode om het gewicht van de garagepoort te berekenen. Het aluminium dat gebruikt wordt in de poort weegt 11 kg/m².
# + Aan de hand van het gewicht kunnen we ook de motor voor de garagepoort bepalen. Voor poorten die meer wegen dan 300 kg gebruiken we motor “X300”.
# Voor poorten van 150 kg tot en met 300 kg gebruiken we motor “A105”. Kleinere poorten tot 150 kg kunnen opgetrokken worden met motor “A101”.
# Iedere motor heeft ook een andere prijs. Maak een methode die, gegeven de motornaam, de juiste prijs geeft.
# # <table>
#     <tr><th>Motornaam</th><th>Toegelaten gewicht</th><th>Prijs</th></tr>
#     <tr><td>A101</td><td> &lt;150kg </td><td> €120</td></tr>
#     <tr><td>A105</td><td> &gt;= 150kg en &lt;= 300 kg </td><td> €220.5</td></tr>
#     <tr><td>X300</td><td>&gt;300 kg</td><td>€250.5</td></tr>
# </table>
# + Maak een methode om de prijs van de poort te berekenen. De formule voor het berekenen van de prijs van de poort is: oppervlakte * 113,5/m² + prijs van de
# motor.
# De bovenstaande prijsberekening is enkel voor de standaard-kleuren. Voor een speciale kleur wordt een toeslag van 10% verrekend op de basisprijs (prijs zonder motor) van de
# garagepoort.
# + Maak een methode voor het genereren van een offertenummer.
# Het formaat van het offerte nummer is `2018_<<NAAM VERKOPER>>_<<integer totaalprijs omgekeerd>>`.
# Zorg ervoor dat de naam van de verkoper in uppercase wordt geschreven.
# Het geheel deel van de totaalprijs wordt omgekeerd en als laatste geplaatst.
# Voorbeeld van een offertenummer van verkoper1 voor een offerte met totaalprijs 912.31 is “2018_VERKOPER1_219”.
RHO = 11 # 11 kg/m2
OPP_PRIJS = 113.5 #113.5/m2


def oppervlakte(hoogte, breedte):
    return hoogte * breedte


def gewicht(oppervlakte, rho):
    return oppervlakte * rho


def prijs_motor(motor):
    prijs_motor = 0
    if motor == "x300":
        prijs_motor = 250.5
    if motor == "A105":
        prijs_motor = 220.5
    if motor == "A101":
        prijs_motor = 120
    return prijs_motor


def prijs_poort(opp, OPP_PRIJS, kleur):
    prijs_poort = opp * OPP_PRIJS
    if kleur == "ja":
        prijs_poort += prijs_poort * 0.1
    prijs_poort += prijs_motor
    return  prijs_poort


def offertenummer(verkoper, prijs_poort):
    print("2018_" + verkoper.upper() + str(int(prijs_poort))[-1::-1])


verkoper = input("Geef de naam van de verkoper in: ")
hoogte = int(input("Geef de hoogte van de poort in: "))
while hoogte <= 2 or hoogte >= 6.5:
    hoogte = int(input("Geef een geldige hoogte in: "))
breedte = int(input("Geef de breedte van de poort in: "))
while breedte <= 2 or breedte >= 8:
    breedte = int(input("Geef een geldige breedte in: "))
kleur = input("Wilt u een speciale kleur? typ 'ja' of 'nee': ")
opp = oppervlakte(hoogte, breedte)
gewicht = gewicht(opp, RHO)
if gewicht >= 300:
    motor = "x300"
elif gewicht >= 150:
    motor = "A105"
else:
    motor = "A101"
prijs_motor = prijs_motor(motor)
prijs_poort = prijs_poort(opp, OPP_PRIJS, kleur)
offertenummer(verkoper, prijs_poort)