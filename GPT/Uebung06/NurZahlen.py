import sys


def main():
    # read all lines from stdin
    numbers = [line for line in sys.stdin]

    # print all lines with floating point numbers
    for line in numbers:
        try:
            print(float(line))
        except:
            pass


if __name__ == "__main__":
    main()
