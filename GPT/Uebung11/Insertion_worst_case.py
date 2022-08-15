s = ""
for i in range(100, 0, -1):
    s += str(i) + "\n"

with open("insertion_worst_case.txt", "w") as f:
    f.write(s)
