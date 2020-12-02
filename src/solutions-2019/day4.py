def only_sorted():
    pwl = [[int(j) for j in str(i)] for i in range(171309, 643604)]
    return list(filter(lambda x: x == sorted(x), pwl))

def part1():
    pwl = only_sorted()
    return list(filter(lambda x: any(freq > 1 for freq in [x.count(freq) for freq in x]), pwl))

print("part1 possible passwords: ", len(part1()))

def part2():
    pwl = only_sorted()
    return list(filter(lambda x: any(freq == 2 for freq in [x.count(freq) for freq in x]), pwl))

print("part2 possible passwords: ", len(part2()))
