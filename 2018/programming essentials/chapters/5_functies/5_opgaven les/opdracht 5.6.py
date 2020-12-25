def get_tienden(getal):
#    return getal * 10 // 1 % 10 maakt niet uit welke twee maar ik prefereer de volgende.
    return int(getal * 10) % 10


print(get_tienden(45.6389))
print((get_tienden(45)))