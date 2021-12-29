# Modifizieren Sie den Code wie in der Aufgabenstellung beschrieben!
def suche(l, e):
    min_index = 0
    max_index = len(l) - 1
    while max_index >= min_index:
        mid_index = (max_index + min_index) // 2
        if l[mid_index] > e:
            max_index = mid_index - 1
        elif l[mid_index] < e:
            min_index = mid_index + 1
        else:
            return mid_index
    return -1


liste = [0, 0, 0, 0, 1, 1, 1, 2, 2, 8, 13, 13, 17, 19, 32, 32, 32, 42, 42]
print("Elemente:", suche(liste, 0))
