import math
from sys import argv


# function that returns the checksum of a number
def checksum(n):
    _sum = 0
    for i in str(n):
        _sum += int(i)
    return _sum


def primes_to_n_lecture(n: int):
    primes = []
    for i in range(2, n + 1):
        is_prime = True
        for prime in primes:
            if prime ** 2 > i:
                break
            if i % prime == 0:
                is_prime = False
                break
        if is_prime:
            primes.append(i)

    return primes


def primes_to_n(n):
    potential_primes = [2]

    for i in range(3, n + 1, 2):
        potential_primes.append(i)

    primes = potential_primes[:]

    for potential_prime in potential_primes:
        for smaller_potential_prime in potential_primes:
            if smaller_potential_prime < potential_prime:
                if potential_prime % smaller_potential_prime == 0:
                    primes.remove(potential_prime)
                    break
            else:
                break

    return primes


# function that returns a list of prime factors of a number
def prime_factors(n):
    factors = []
    for prime in primes_to_n(n):
        if n % prime == 0:
            factors.append(prime)
    return factors


# function that returns true if the number is a square number
def is_square_number(n):
    for i in range(1, int(math.sqrt(n)) + 1):
        if i * i == n:
            return True
    return False


def main():
    parameter = int(argv[1])

    print(checksum(parameter))
    print(prime_factors(parameter))
    print(is_square_number(parameter))


if __name__ == '__main__':
    main()
