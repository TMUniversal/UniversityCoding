def main():
    # take user input "pairs" as integer
    n_pairs = int(input("Wie viele Wortpaare sollen eingegeben werden? "))

    # create empty list for word pairs
    pairs = []

    # take user input twice for each word pair
    for i in range(n_pairs):
        print(f"Bitte geben Sie das {i + 1}te Wortpaar ein")
        pairs.append([
            input("Bitte erstes Wort eingeben:\t"),
            input("Bitte zweites Wort eingeben:\t")
        ])

    # print the array
    print(pairs)

    # save the inverse of the array as a new array
    pairs_inverse = pairs[::-1]

    # flatten the array
    pairs_flat = []

    for sub_list in pairs_inverse:
        for item in sub_list:
            pairs_flat.append(item)

    # print the flattened array
    print(pairs_flat)

    # print the inverse of the flattened array
    print(pairs_flat[::-1])


if __name__ == "__main__":
    main()
