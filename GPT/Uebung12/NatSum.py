import sys

sum = 0
ret = ""
for i in range(1, int(sys.argv[1]) + 1):
    if ret != "":
        ret += " + " + str(i)
    else:
        ret += str(i)
    sum += i

ret += " = " + str(sum)

print(ret)