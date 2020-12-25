"""
ingave ... seconden
output ... u ... min ... sec
"""
seconden = int(input("Geef het aantal seconden in: "))
print(seconden // (60 * 60), "u", seconden % (60 * 60) // 60, "min", seconden % 60, "seconden")
