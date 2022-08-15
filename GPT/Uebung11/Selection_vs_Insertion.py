def selection_sort(arr: list) -> list:
    anz_vergleich = 0
    anz_vertausch = 0

    for i in range(len(arr)):
        min = i
        for j in range(i, len(arr)):
            anz_vergleich += 1
            if arr[j] < arr[min]:
                min = j
        anz_vertausch += 1
        arr[i], arr[min] = arr[min], arr[i]

    print("Selection [vergleich/vertausch]", anz_vergleich, anz_vertausch)

    return arr


def insertion_sort(arr: list) -> list:
    anz_vergleich = 0
    anz_vertausch = 0

    for i in range(1, len(arr)):
        cur = i
        for j in range(i - 1, -1, -1):
            anz_vergleich += 1
            if arr[cur] < arr[j]:
                anz_vertausch += 1
                arr[cur], arr[j] = arr[j], arr[cur]
                cur -= 1
            else:
                break

    print("Insertion [vergleich/vertausch]", anz_vergleich, anz_vertausch)

    return arr


arr1 = [8, 3, 5, 1, 4]
arr2 = [2, 6, 4, 6, 8]
arr3 = [9, 8, 6, 2, 1]

print(arr1)
selection_sort(arr1[:])
insertion_sort(arr1[:])

print(arr2)
selection_sort(arr2[:])
insertion_sort(arr2[:])

print(arr3)
selection_sort(arr3[:])
insertion_sort(arr3[:])
