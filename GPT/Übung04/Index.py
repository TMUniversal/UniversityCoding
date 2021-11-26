import math
import random


def main():
    # Array with random strings
    array = ["Hallo", "Welt", "Wie", "geht", "es", "dir", "?"]

    # Print Array values at the following indices

    # positive integer smaller than the array length
    print(array[len(array) - 2])

    # positive integer equal to or larger than the array length
    # print(array[len(array) + 1]) # IndexError: list index out of range

    # negative integer with an absolute value smaller than or equal to the array length
    print(array[-1])

    # negative integer with an absolute value larger than the array length
    # print(array[-len(array) - 1]) # IndexError: list index out of range


if __name__ == "__main__":
    main()
