import sys


def main():
    # receive a letter as a command line argument
    target_letter = sys.argv[1].lower()

    # search for the letter in the input, increment the counter if found
    counter = 0
    for line in sys.stdin:
        for letter in line.lower():
            if letter == target_letter:
                counter += 1

    sys.stdout.write(f'Im vorliegenden Text gibt es den Buchstaben \'{target_letter}\' so oft: {counter} mal.\n')


if __name__ == "__main__":
    main()
