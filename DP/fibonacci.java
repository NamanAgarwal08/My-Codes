public class fibonacci{
    public static void main(String[] args) {
        int n = 6;
        int f[] = new int[n + 1];
        System.out.println(fib(n, f));
        System.out.println(fiboTabulation(n));
    }
    
    public static int fib(int n, int f[]) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (f[n] != 0) {
            return f[n];
        }
        return f[n] = fib(n - 1, f) + fib(n - 2, f);
    }
    
    public static int fiboTabulation(int n) {
        int f[] = new int[n + 1];
        f[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            f[i] = f[i - 2] + f[i - 1];
        }
        return f[n];
    }
}