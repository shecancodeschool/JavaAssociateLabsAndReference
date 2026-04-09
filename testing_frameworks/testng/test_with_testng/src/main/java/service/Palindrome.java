package service;

public class Palindrome {

    public static boolean isPalindrome(String word) {

        int left = 0;
        int right = word.length() - 1;
        String formatedWord = word.toLowerCase();
        while (left < right) {
            if (formatedWord.charAt(left) != formatedWord.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
