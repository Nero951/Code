package solution;

public class GrayCode {
    public String[] getGray(int n) {
        // write code here
        String[] str = null;
        if(n==1){
            str = new String[]{"0","1"};
        }else{
            String[] temp = getGray(n-1);
            str = new String[2*temp.length];
            for (int i = 0; i<str.length ; i++) {
                str[i] = "0" + str[i];
                str[str.length-1-i] = "1" + str[i];
            }
        }
        return str;
    }
}
