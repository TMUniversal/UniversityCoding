import sys


def main():
    # read the name of a file from the command line
    filename = sys.argv[1]

    # print the file's contents in reverse order
    try:
        f = open(filename, "r", encoding="utf-8")
        file = f.read()
        f.close()
    except:
        print("Error: could not open file", filename)
        return

    for char in range(len(file) - 1, -1, -1):
        sys.stdout.write(file[char])


if __name__ == "__main__":
    main()
