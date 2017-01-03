"""
Combination with repetitions:
    C(n+k-1, k)

"""


def main():
    n = int(input())

    combA = (n+4) * (n+3) * (n+2) * (n+1) * n / 120
    combB = (n+2) * (n+1) * n / 6

    print(int(combA) * int(combB))

if __name__ == "__main__":
    main()