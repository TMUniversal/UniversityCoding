import sys as sus

# arr = [1, 2, 3, 4, 5]
# Aufruf #1         [1, 2, 3, 4, 5]
#  -> Aufruf #2     [1, 2, 3, 4]
#  --> Aufruf #3    [1, 2, 3]
#  ---> Aufruf #4   [1, 2]
#  ----> Aufruf #5  [1]
#  -----> Aufruf #6 [] --> 0
#  ----> Aufruf #5  [1], 0 --> 1
#  ---> Aufruf #4   [1, 2], 1 --> 3
#  --> Aufruf #3    [1, 2, 3], 3 --> 6
#  -> Aufruf #2     [1, 2, 3, 4], 6 --> 10
# Aufruf #1         [1, 2, 3, 4, 5], 10 --> print(15)
def summe(arr):
    # Alle Elemente des Arrays aufsummieren
    # Ohne Schleifen (also rekursiv)!
    if len(arr) > 0:
        # slicen vom array
        # [begin=0:end=len(arr):step=1] --> begin inclusive; end exclusive;
        return summe(arr[:-1]) + arr[-1]
    else:
        return 0

def multiplikation(arr):
    # Alle Elemente des Arrays mit einander multiplizieren
    # Kein Schleifen-Verbot. Lol?
    # start inclusive = 0, stop exclusive, step = 1
    ergebnis = 1
    for i in range(len(arr)):
        # arr[i] Element aus dem jeweligen Durchlauf
        ergebnis = ergebnis * arr[i] # Alternativ: ergebnis *= arr[i]
    
    return ergebnis

def verdoppeln(arr : list):
    # Elemente des Arrays durch ihr Inverses "verdoppeln"
    # [1, 2, -3, 4, -5, 5] --> [1, 2, -3, 4, -5, 5, -1, -2, 3, -4]
    # Inverse: 1 -> -1; -1 -> 1
    
    # Vorgehensweise 1: Pro Element prüfen, ob das Inverse enthalten ist, falls nicht, hinzufügen, andernfalls nichts machen
    for value in arr:
        # prüfen, ob das inverse bereits im Array ist
        if -value not in arr:
            arr.append(-value) # arr = arr + [-value] == arr += [-value]

    return arr

# Hauptprogramm --> Zahlen als Programmparameter (beliebig viele)
# letzter Parameter bestimmt, welche der oben definierten Funktionen für die Zahlen genutzt werden soll
# s -> summe; m -> multiplikation; d -> verdoppeln
# sus.argv[0] --> "uebung10.py" -- sus.argv[1]

arr = []

for value in sus.argv:
    try:
        arr.append(int(value))
    except ValueError:
        pass

result = None

if sus.argv[-1] == "s":
    result = summe(arr) # "list comprehension"
elif sus.argv[-1] == "m":
    result = multiplikation(arr)
elif sus.argv[-1] == "d":
    result = verdoppeln(arr)

print(result)