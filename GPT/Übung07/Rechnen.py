import sys


def min_fn(values):
    _min = values[0]
    for value in values:
        if value < _min:
            _min = value

    return _min


def max_fn(values):
    _max = values[0]
    for value in values:
        if value > _max:
            _max = value

    return _max


def avg_fn(values):
    _sum = 0
    for value in values:
        _sum += value

    return _sum / len(values)


def main():
    # read float values from standart input (sys.stdin), store them in a list
    lines = [line for line in sys.stdin]

    # convert the list to a float list
    values = []
    for line in lines:
        try:
            values.append(float(line))
        except:
            pass

    # calculate the average of the values
    average = avg_fn(values)

    # calcuate the maximum of the values
    maximum = max_fn(values)

    # calculate the minimum of the values
    minimum = min_fn(values)

    # print the results
    print("Average: {:.2f}".format(average))
    print("Minimum: {:.2f}".format(minimum))
    print("Maximum: {:.2f}".format(maximum))


if __name__ == "__main__":
    main()
