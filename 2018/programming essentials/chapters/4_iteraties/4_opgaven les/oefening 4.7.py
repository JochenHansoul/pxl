for i in range(-10,11):
    if i > 0:
        print("+", str(i))
    else:
        print(i)

#een efficientere oplossing zonder een if (want nu worden al de uitkomsten getest.
for i in range(-10, 1):
    print(i)
for i in range(1, 11):
    print("+", i)