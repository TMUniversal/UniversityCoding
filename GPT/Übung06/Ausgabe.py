import os


def main():
    # get the path of the current script
    path = os.path.abspath(__file__)
    # print the contents of the file
    with open(path, 'r') as f:
        print(f.read())


if __name__ == "__main__":
    main()
