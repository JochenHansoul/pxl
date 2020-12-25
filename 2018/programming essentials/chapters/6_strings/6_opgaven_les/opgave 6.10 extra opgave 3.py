# maak een afdruk van de ascii tabel
# output: een tabel met 12
#               1   2   3   4   5
#
# rij 32        32  48  64               stappen van 16
# rij 33


for rij in range(32, 48):
    for kol in range(6):
        ascii = rij + 16 * kol
        print("{:>3} {:<3}".format(ascii, chr(ascii)), end="")
    print()

#geformatteerde output
# print("{:>3} {:<3}".format(ascii,chr(ascii)), end="")