def summe():
    eingabe = None

    while type(eingabe) != float:
        try:
            eingabe = float(input("Bitte Zahl eingeben / 0 für Ergebnis: "))
        except ValueError:
            print("Das war keine Zahl. Bitte versuche es erneut.")

    if eingabe == 0:
        return 0
    else:
        return eingabe + summe()


if __name__ == "__main__":
    print(summe())
