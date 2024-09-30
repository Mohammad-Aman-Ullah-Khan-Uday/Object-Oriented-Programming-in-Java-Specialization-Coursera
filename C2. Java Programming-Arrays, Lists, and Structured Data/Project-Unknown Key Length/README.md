# Programming-Exercise-Unknown-Key-Length
Assignments from OOP Course on Java Programming: Arrays, Lists, and Structured Data, week 4. https://www.coursera.org/learn/java-programming-arrays-lists-data/supplement/B1ENJ/programming-exercise-unknown-key-length

PROJECT TITLE: "Programming Exercise: Unknown Key Length"

PURPOSE OF PROJECT: Assignment : English Language, Unknown Key Length
                    Modify program that breaks a Vigenère cipher, where you know 
                    that the language is English, but not the key length.  
                    task 1 - In the VigenereBreaker class, write the public method 
                    readDictionary, which has one parameter—a FileResource fr. 
                    This method should first make a new HashSet of Strings, then 
                    read each line in fr (which should contain exactly one word per line), 
                    convert that line to lowercase, and put that line into the HashSet that 
                    you created. The method should then return the HashSet representing 
                    the words in a dictionary. All the dictionary files, including the 
                    English dictionary file, are included in the starter program you download. 
                    They are inside the folder called ‘dictionaries’.
                    task 2 - In the VigenereBreaker class, write the public method countWords, 
                    which has two parameters—a String message, and a HashSet of Strings 
                    dictionary. This method should split the message into words 
                    (use .split(“\\W+”), which returns a String array), iterate over those 
                    words, and see how many of them are “real words”—that is, how many appear 
                    in the dictionary. Recall that the words in dictionary are lowercase. 
                    This method should return the integer count of how many valid words it 
                    found.
                    task 3 - In the VigenereBreaker class, write the public method breakForLanguage, 
                    which has two parameters—a String encrypted, and a HashSet of Strings 
                    dictionary. This method should try all key lengths from 1 to 100 
                    (use your tryKeyLength method to try one particular key length) to 
                    obtain the best decryption for each key length in that range. For each 
                    key length, your method should decrypt the message 
                    (using VigenereCipher’s decrypt method as before), and count how many 
                    of the “words” in it are real words in English, based on the dictionary 
                    passed in (use the countWords method you just wrote). This method should 
                    figure out which decryption gives the largest count of real words, and 
                    return that String decryption. Note that there is nothing special about 
                    100; we will just give you messages with key lengths in the range 1–100. 
                    If you did not have this information, you could iterate all the way to 
                    encrypted.length(). Your program would just take a bit longer to run.

DATE: 31.07.2023

HOW TO START THIS PROJECT: Use BlueJ Environment to open project named 
                           "package.bluej". Find inside of this project 4 
                           classes: 
                           CaesarCipher (Caesar Cipher decryption and 
                           encryption algorithm);
                           CaesarCracker (Caesar Cipher decryption based on
                           frequency of a certain letter in a language)
                           VigenereCipher (Vigenere Cipher encryption and
                           decryption algorithm)
                           VigenereBreaker (Vigenere Cipher decryption based 
                           on frequency of a specific letter in a language, 
                           specifically it slices strings in a known amount 
                           of slices based on key length and finds the key 
                           which was used to encrypt a message and uses it to
                           decrypt the message)
                           - compile, create object of 
                           type VigenereBreaker and start the function: 
                           "breakViginere" for task 1, 2 and 3;

AUTHOR: Gusev Roman

USER INSTRUCTIONS: You will need library: "edu.duke.\*"
                   (simplified version of File function from Java)
                   and "java.util.\*"
                   Be careful! When launching created object and 
                   accessing the function "breakViginere", you will
                   need to choose first encrypted message and second
                   file - desired dictionary (English).
