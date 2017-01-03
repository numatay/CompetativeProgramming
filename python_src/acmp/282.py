
def main():
    args = input().split()
    n = int(args[0])
    m = int(args[1])
    sum_n = (1 + n) * n / 2
    sum_m = (1 + m) * m / 2
    print(int(sum_n * sum_m))


if __name__ == "__main__":
    main()
