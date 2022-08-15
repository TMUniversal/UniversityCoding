def selection_sort(arr: list):
    for ptr in range(len(arr)):
        min_ptr = ptr
        for i in range(ptr, len(arr)):
            if arr[i] < arr[min_ptr]:
                min_ptr = i
        arr[ptr], arr[min_ptr] = arr[min_ptr], arr[ptr]
    return arr
