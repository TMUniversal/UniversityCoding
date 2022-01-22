# fibonacci zahl am index n

# Stelle:   1 2 3 4 5 6
# zahl:     1 1 2 3 5 8
import functools


# cache: zwischenspeicher für funktionsaufrufe
@functools.lru_cache(maxsize=512)
def fibonacci(n: int):
    if n == 1 or n == 2:
        return 1
    else:
        return fibonacci(n - 1) + fibonacci(n - 2)


if __name__ == "__main__":
    print(fibonacci(7))
