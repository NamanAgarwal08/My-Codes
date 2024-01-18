public class trappingRainwater {
    public static void trappedRainwater(int height[]) {
        int leftMax[] = new int[height.length];
        leftMax[0] = height[0];
        int rightMax[] = new int[height.length];
        rightMax[height.length-1] = height[height.length-1];
        for (int i = 1; i < height.length; i++) {
            leftMax[i]=Math.max(height[i],leftMax[i-1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        int totVol = 0;
        for (int i = 0; i < height.length; i++) {
            totVol += (Math.min(leftMax[i], rightMax[i]) - height[i]);
        }
        
        System.out.println(totVol);
        
    }

    public static void main(String args[]) {
        int height[] = { 4, 2, 0, 6, 3, 2, 5 };
        // trappedRainwater(height);
        String str = "ABCd";
        System.out.println(str.substring(0, 0));
        int n = -999999999;
        int n2 = '2'-48;
        long n3 = 1;
        
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                break;
            }
            System.out.println(i);
        }
    }
    
    
}
