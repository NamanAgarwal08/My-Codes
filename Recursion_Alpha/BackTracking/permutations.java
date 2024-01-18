public class permutations {

    public static void findPermutations(String str,String ans) {
        // base case
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        //recursion
        for (int i = 0; i < str.length(); i++) {
            findPermutations(str.substring(0, i)+str.substring(i+1,str.length()), ans+str.charAt(i));
        }

    }
    public static void main(String args[]) {
        String str = "abc";
        findPermutations(str, "");
    }
}








