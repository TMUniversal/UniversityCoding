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

    # save the inverse of the array as a new array, flattened
    pairs_inverse = []
    for i in range(len(pairs) - 1, -1, -1):
        pairs_inverse += pairs[i]

    # reverse the word-pair arrays inside "pairs", save the result in "pairs_content_inverse"
    pairs_content_inverse = []
    for i in range(len(pairs)):
        # since the pairs consist only of two words, we can assign the first word to the second word and vice versa
        pairs_content_inverse += [pairs[i][1], pairs[i][0]]

    # print the results
    print(pairs)
    print(pairs_inverse)
    print(pairs_content_inverse)


if __name__ == "__main__":
    main()
