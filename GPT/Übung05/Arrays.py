def main():
    # read three float numbers from user input
    a = float(input("a: "))
    b = float(input("b: "))
    c = float(input("c: "))

    # print the average of a, b, and c
    print("Average:", (a + b + c) / 3)

    # save a, b, and c into an array
    array = [a, b, c]

    # remove the lowest value from the array
    array.remove(min(array))

    # print the new array
    print(array)


if __name__ == "__main__":
    main()
