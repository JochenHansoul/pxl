# Geef een datum in de vorm van dd-mm-jjjj
# bereken welke dag van het jaar dit is.
#   bvb 22-10-2018 is dagnummer 295
#   hou rekening met schrikkeljaar, zie ofening 5.2
def is_schrikkeljaar(jaar):
    return jaar % 4 == 0 and jaar % 100 != 0 or jaar % 400 == 0

datum = input("geef een datum in dd/mm/jjjj ")
dagen_list = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
datum_geg = datum.split("/")
som = 0
for i in range(int(datum_geg[1]) - 1):
    som += dagen_list[i]
if is_schrikkeljaar(int(datum_geg[2])) and int(datum_geg[1]) > 2:
    som += 1
som += int(datum_geg[0])
print(datum, "is op dagnummer", som)