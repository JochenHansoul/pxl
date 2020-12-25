# meter -> voet 1 meter = 3.2808399
# voor 1, 1.5, 2, ..., 19.5, 20
# Je moet 15 posities voorzien, format gebruiken: teks meter en teks voet.
print("{:^15} {:15}".format("meter", "voet"))
for meter in range(2, 41):
    meter = meter / 2
    voet = meter * 3.2808399
    print("{:15.2f} {:15.2f}".format(meter, voet))

#wordt niet op examen gevraagd, steek uw tijd er niet in!