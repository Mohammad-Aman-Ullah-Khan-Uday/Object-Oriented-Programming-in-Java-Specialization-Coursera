import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
    private int[] keyFinal;
    
    public String sliceString(String message, int whichSlice, int totalSlices) {
        StringBuilder messageBuilder = new StringBuilder(message);
        StringBuilder newString = new StringBuilder();
        for (int i = whichSlice; i < message.length(); i += totalSlices) {
            newString.append(messageBuilder.charAt(i));
        }
        return newString.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        CaesarCracker cc = new CaesarCracker(mostCommon);
        int[] key = new int[klength];
        for (int i = 0; i < klength; i++) {
            String msgPart = sliceString(encrypted, i, klength);
            int keyPart = cc.getKey(msgPart);
            key[i] = keyPart;
        }
        return key;
    }

    public HashSet<String> readDictionary (FileResource fr) {
        HashSet<String> dictionary = new HashSet<String>();
        for (String line : fr.lines()) {
            line = line.toLowerCase();
            dictionary.add(line);
        }
        return dictionary;
    } 
    
    public int countWords (String message, HashSet<String> dictionary) {
        int counter = 0;
        String[] splitMsg = message.split("\\W+");
        for (String word : splitMsg) {
            if (dictionary.contains(word.toLowerCase())) {
                counter++;
            }
        }
        return counter;
    }
    
    public String breakForLanguage (String encrypted, HashSet<String> dictionary) {
        VigenereCipher vc;
        String decryptedFinal = "";
        int maxWords = 0;
        for (int keyLength = 1; keyLength <= 100; keyLength++) {
            int[] key = tryKeyLength(encrypted, keyLength, 'e');
            vc = new VigenereCipher(key);
            String decrypted = vc.decrypt(encrypted);
            int countWords = countWords(decrypted, dictionary);
            if (maxWords <= countWords) {
                maxWords = countWords;
                decryptedFinal = decrypted;
                keyFinal = key;
            }
        }
        System.out.println("This file contains " + maxWords + " valid words out of " + encrypted.split("\\W+").length); 
        return decryptedFinal;
    }
    
    public void breakVigenere () {
        FileResource fr = new FileResource();
        String message = fr.asString();
        FileResource dict = new FileResource();
        HashSet<String> dictionary = readDictionary(dict);
        String decrypted = breakForLanguage(message, dictionary);
        System.out.println(decrypted);
        System.out.println("Key length: " + keyFinal.length);
        System.out.print("Key: ");
        for (int i = 0; i < keyFinal.length; i++) {
            System.out.print(keyFinal[i] + " ");
        }
        
    }
}
