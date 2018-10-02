class SetBits{

    static int countSetBits( int n)
    {
        int bitCount = 0;
        for (int i = 1; i <= n; i++)
            bitCount += countSetBitsUtil(i);

        return bitCount;
    }

    static int countSetBitsUtil( int x)
    {
        if (x <= 0)
            return 0;
        return (x % 2 == 0 ? 0 : 1) +
                countSetBitsUtil(x / 2);
    }

   public static void main(String[] args)
    {
        int n = 4;
        System.out.print("Total set bit count is ");
        System.out.print(countSetBits(n));
    }
}