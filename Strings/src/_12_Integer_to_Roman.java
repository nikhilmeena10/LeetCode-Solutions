public class _12_Integer_to_Roman {

    //top voted solution
    //no ds algo tested? weird ques
    public static String intToRoman(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
    }

    //another solution
    /*public static String intToRoman(int num){
        if (num < 1 || num > 3999) return "";

        StringBuilder result = new StringBuilder();

        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

        int i = 0;
        //iterate until the number becomes zero, NO NEED to go until the last element in roman array
        while (num >0) {
            while ( num >= values[i]) {
                num -= values[i];
                result.append(roman[i]);
            }
            i++;
        }
        return result.toString();
    }*/

    //My solution
    /*public String intToRoman(int num) {
        Map<Integer, HashMap<Integer, String>> hm = new HashMap<>();
        HashMap<Integer, String> single = new HashMap<>();
        single.put(1,"I");
        single.put(5,"V");
        single.put(10,"X");
        hm.put(1,single);
        HashMap<Integer, String> dual = new HashMap<>();
        dual.put(1,"X");
        dual.put(5,"L");
        dual.put(10,"C");
        hm.put(2,dual);
        HashMap<Integer, String> triple = new HashMap<>();
        triple.put(1,"C");
        triple.put(5,"D");
        triple.put(10,"M");
        hm.put(3,triple);
        HashMap<Integer, String> quad = new HashMap<>();
        quad.put(1, "M");
        hm.put(4, quad);
        StringBuilder sb = new StringBuilder();
        while(num>0) {
            int digits = (int)(Math.floor(Math.log10(num) + 1));
            int tenpow = (int)Math.pow(10,digits-1);
            int firstdigit = num/tenpow;
            HashMap<Integer,String> im = hm.get(digits);
            switch(firstdigit) {
                case 1: sb.append(im.get(1));break;
                case 2: sb.append(im.get(1));
                    sb.append(im.get(1));break;
                case 3: sb.append(im.get(1));
                    sb.append(im.get(1));
                    sb.append(im.get(1));break;
                case 4: sb.append(im.get(1));
                    sb.append(im.get(5));break;
                case 5: sb.append(im.get(5));break;
                case 6: sb.append(im.get(5));
                    sb.append(im.get(1));break;
                case 7: sb.append(im.get(5));
                    sb.append(im.get(1));
                    sb.append(im.get(1));break;
                case 8: sb.append(im.get(5));
                    sb.append(im.get(1));
                    sb.append(im.get(1));
                    sb.append(im.get(1));break;
                case 9:sb.append(im.get(1));
                    sb.append(im.get(10));break;
            }
            num = num%tenpow;
        }
        return sb.toString();
    }*/

}
