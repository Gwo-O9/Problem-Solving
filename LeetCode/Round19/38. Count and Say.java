class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        return cns(n);
    }

    public String cns(int n) {
        if (n == 1) {
            return "1";
        }
        String temp = cns(n - 1);
        int i = 0;
        int count = 1;
        int t = temp.length();
        StringBuilder ans = new StringBuilder();
        while (i < t) {
            if (i == t - 1) {
                ans.append(count);
                ans.append(temp.charAt(i));
                i++;
                continue;
            } else if (temp.charAt(i) != temp.charAt(i + 1)) {
                ans.append(count);
                ans.append(temp.charAt(i));
                i++;
                count = 1;
                continue;
            } else if (temp.charAt(i) == temp.charAt(i + 1)) {
                count++;
                i++;
                continue;
            }
        }
        return ans.toString();
    }
}
