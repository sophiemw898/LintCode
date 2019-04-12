public class Solution {
    /**
     * @param S: 
     * @return: nothing
     */
    public String  toGoatLatin(String S) {
        StringBuilder sb = new StringBuilder();
        
        String[] words = S.split(" ");
        //Set<Character> vowel = new HashSet<>('a','e','i','o','u','A','E','I','O','U');
        Set<Character> vowel = new HashSet<>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');
        vowel.add('A');
        vowel.add('E');
        vowel.add('I');
        vowel.add('O');
        vowel.add('U');
        //System.out.println(vowel);
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (vowel.contains(word.charAt(0))) {
                sb.append(word);
                sb.append("ma");
                int count = i + 1;
                while (count > 0) {
                    sb.append("a");
                    count--;
                }
                sb.append(" ");
            } else {
                sb.append(word.substring(1));
                sb.append(word.charAt(0));
                sb.append("ma");
                int count = i + 1;
                while (count > 0) {
                    sb.append("a");
                    count--;
                }
                sb.append(" ");
            }
        }
        
        return sb.toString().substring(0, sb.toString().length() - 1);
    }
}
