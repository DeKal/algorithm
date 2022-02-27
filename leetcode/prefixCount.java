// https://leetcode.com/contest/weekly-contest-282/problems/counting-words-with-a-given-prefix/
class prefixCount {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (int i=0; i<words.length; ++i) {
            if (words[i].startsWith(pref)) {
                count++;
            }
        }
        return count;
    }
}