import sys as sus

from Fibonacci import fibonacci
from Summe import summe


def main():
    if len(sus.argv) > 1:
        try:
            fib_index = int(sus.argv[1])
        except ValueError:
            print("Parameter muss eine Zahl sein.")
            return

        if fib_index <= 0:
            print("Zahl muss größer 0 sein.")
            return

        print(fibonacci(fib_index))

    else:
        try:
            print(summe())
        except ValueError:
            print("Eingaben müssen Zahlen sein.")


if __name__ == "__main__":
    main()
