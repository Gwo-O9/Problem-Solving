class Solution {
    public String reverseVowels(String s) {
        int i = 0;
        int j = s.length()-1;
        char ch[] = s.toCharArray();
        while(i<j){
            while(!isVowel(ch[i]) && i<j) i++;
            while(!isVowel(ch[j]) && i<j) j--;
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }
        return new String(ch);
    }

    public boolean isVowel(char c){
        if(c== 'a' || c=='A' || c=='e' || c=='E' || c=='i' || c=='I' || c=='o' || c=='O' || c=='u' || c=='U') return true;    
        else return false;    
    }
}
