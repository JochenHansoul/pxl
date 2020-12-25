def schrikkeljaar(jaar):
    if jaar % 4 == 0:
        if jaar % 100 == 0:
            if jaar % 400 == 0:
                return True
            else:
                return False
        else:
            return True
    else:
        return False


jaar = int(input("Geef het jaar in: "))
print(schrikkeljaar(jaar))