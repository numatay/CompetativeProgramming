"""
Hint to solving this problem is Binomial Coef.

C(n,1) + C(n,2) + C(n,3) + C(n,4) + ... + C(n,n) = 2^n - 1;

"""


def main():
    n = int(input())
    print((1 << n) - n - 1)


if __name__ == "__main__":
    main()