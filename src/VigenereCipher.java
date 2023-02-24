import java.util.Locale;

public class VigenereCipher {
    private String key;
    private String alphabet;

    public VigenereCipher(String key) {
        this.alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        this.key = key.toLowerCase();
    }

    public String getKey() {
        return key;
    }

    public String getAlphabet() {
        return alphabet;
    }

    public String encode(String txt) {
        int lengthOftxt = txt.length();
        txt = txt.toLowerCase();
        char[] encodedTxt = new char[lengthOftxt];

        for (int i = 0; i < lengthOftxt; i++) {
            if (i == key.length()) {
                i = 0;
            }
            if (i == lengthOftxt || key.length() == lengthOftxt) {
                break;
            }
            key = key + (key.charAt(i));
        }
        for (int i = 0; i < lengthOftxt; i++) {
            if (alphabet.indexOf(txt.charAt(i)) != -1) {
                encodedTxt[i] = (char) (((txt.charAt(i) + key.charAt(i) + 14) % 26) + 'A');
            } else{
                encodedTxt[i] = txt.charAt(i);
            }
        }
        String encodedText = (String.valueOf(encodedTxt)).toLowerCase();
        return encodedText;
    }

    public String decode(String encodedTxt) {
        int lengthOfEncodedtxt = encodedTxt.length();
        char[] txt = new char[lengthOfEncodedtxt];

        for (int i = 0; i < lengthOfEncodedtxt; i++) {
            if (i == key.length()) {
                i = 0;
            }
            if (i == lengthOfEncodedtxt || key.length() == lengthOfEncodedtxt) {
                break;
            }
            key = key + (key.charAt(i));
        }

        encodedTxt = encodedTxt.toLowerCase();
        for (int i = 0; i < lengthOfEncodedtxt; i++) {
            if (alphabet.indexOf(encodedTxt.charAt(i)) != -1) {
                txt[i] = (char) (((encodedTxt.charAt(i) - key.charAt(i) + 26) % 26) + 'A');
            } else{
                txt[i] = encodedTxt.charAt(i);
            }
        }
        String text = (String.valueOf(txt)).toLowerCase();
        return text;
    }
}
