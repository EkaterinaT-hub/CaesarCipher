public class CaesarCipher {

    public static String encrypt(String text, int key) {
        return shiftText(text, key);
    }

    public static String decrypt(String text, int key) {
        return shiftText(text, -key);
    }

    private static String shiftText(String text, int key) {
        StringBuilder result = new StringBuilder();
        int len = Alphabet.CHARS.length;

        for (char ch : text.toLowerCase().toCharArray()) {
            int index = indexOf(ch);
            if (index != -1) {
                int newIndex = (index + key + len) % len;
                result.append(Alphabet.CHARS[newIndex]);
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    private static int indexOf(char ch) {
        for (int i = 0; i < Alphabet.CHARS.length; i++) {
            if (Alphabet.CHARS[i] == ch) return i;
        }
        return -1;
    }
}