def main():
    # create array with multiples of 3 (from 3 to 30)
    array = [i for i in range(3, 31, 3)]

    # reverse the array, save in array2
    array2 = array[::-1]

    # print the arrays
    print(array)
    print(array2)


if __name__ == "__main__":
    main()
