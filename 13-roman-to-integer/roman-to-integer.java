class Solution {
    public int romanToInt(String s) {
        StringBuilder str = new StringBuilder(s);
        for (int i = 0; i < str.length() - 1; i++) {
            convert(str,str.substring(i,i+2),i);
        }

        int ans = 0;

        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case 'I':
                    ans += 1;  
                    break;

                case 'V':
                    ans += 5;
                    break;

                case 'X':
                    ans += 10;
                    break;

                case 'L':
                    ans += 50;
                    break;

                case 'C':
                    ans += 100;
                    break;

                case 'D':
                    ans += 500;
                    break;

                case 'M':
                    ans += 1000;
                    break;
            
                default:
                    break;
            }
        }

        return ans;
    }

    private void convert(StringBuilder str,String s,int index){
        switch (s) {
            case "IV":
                str.replace(index, index+2, "IIII");
                break;

            case "IX":
                str.replace(index, index+2, "VIIII");
                break;
            
            case "XL":
                str.replace(index, index+2, "XXXX");
                break;
            
            case "XC":
                str.replace(index, index+2, "LXXXX");
                break;
            
            case "CD":
                str.replace(index, index+2, "CCCC");
                break;

            case "CM":
                str.replace(index, index+2, "DCCCC");
                break;
        
            default:
                break;
        }
    }
}