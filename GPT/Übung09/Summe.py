def summe():
    eingabe = float(input("Bitte Zahl eingeben: "))

    if eingabe == 0:
        return 0
    else:
        return eingabe + summe()


if __name__ == "__main__":
    print(summe())
