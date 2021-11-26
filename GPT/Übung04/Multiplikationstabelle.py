import sys


def main():
    # read two integers as command line arguments x and y, assuming x < y
    x = int(sys.argv[1])
    y = int(sys.argv[2])

    # print the numbers in range (x, y)
    for i in range(x, y + 1):
        print(f'\t{i}', end='')
    print('')

    # print the multiplication table
    for i in range(x, y + 1):
        print(i, end='\t')
        for j in range(x, y + 1):
            print(i * j, end='\t')
        print('')


if __name__ == '__main__':
    main()
