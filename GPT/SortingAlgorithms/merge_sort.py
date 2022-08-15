def merge(arr: list, lo: int, mid: int, hi: int, aux: list) -> None:
    """
    Merge two sorted subarrays in place.
    [lo, mid] and [mid + 1, hi] are sorted.
    """
    aux[lo:hi + 1] = arr[lo:hi + 1]
    i = lo
    j = mid + 1
    for k in range(lo, hi + 1):
        if i > mid:
            arr[k] = aux[j]
            j += 1
        elif j > hi:
            arr[k] = aux[i]
            i += 1
        elif aux[j] < aux[i]:
            arr[k] = aux[j]
            j += 1
        else:
            arr[k] = aux[i]
            i += 1


def sortPart(arr: list, lo: int, hi: int, aux: list) -> None:
    """
    Sort a subarray in place.
    """
    if hi <= lo:
        return
    mid = lo + (hi - lo) // 2
    sortPart(arr, lo, mid, aux)
    sortPart(arr, mid + 1, hi, aux)
    merge(arr, lo, mid, hi, aux)


def mergeSort(arr: list) -> None:
    """
    Sort an array in place.
    """
    aux = [0] * len(arr)
    sortPart(arr, 0, len(arr) - 1, aux)
