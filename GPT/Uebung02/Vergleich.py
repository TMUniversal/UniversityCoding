import sys

a = int(sys.argv[1])
b = int(sys.argv[2])
c = int(sys.argv[3])

if (int(a) == int(b) == int(c)):
    print("Gleich")

if (int(a) < int(b) < int(c)):
    print("Aufsteigend sortiert")

if (int(a) > int(b) > int(c)):
    print("Absteigend sortiert")

if not (int(a) == int(b) == int(c)) and not (int(a) < int(b) < int(c)) and not (int(a) > int(b) > int(c)):
    print("Unsortiert")
