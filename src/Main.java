import java.io.File;
import java.util.HashSet;
import java.util.Scanner;

import static java.lang.Math.abs;

public class Main {

    public static String[] makeArrayWithoutEmptySpace(String text) {
        String newtext = text.replaceAll("'", "");
        String[] wordsArrayOfText = newtext.split("[!,(?<=\\.):\\s+]");
        int emptySpace = 0;
        for (int i = 0; i < wordsArrayOfText.length; i++) {
            if ("".equalsIgnoreCase(wordsArrayOfText[i])) {
                emptySpace++;
            }
        }
        String[] wordsArrayOfTextWidaltEmptySpase = new String[wordsArrayOfText.length - emptySpace];
        int index = 0;
        for (int i = 0; i < wordsArrayOfText.length; i++) {
            if (!wordsArrayOfText[i].isEmpty()) {
                wordsArrayOfTextWidaltEmptySpase[index] = wordsArrayOfText[i];
                index++;
            }
        }

        return wordsArrayOfTextWidaltEmptySpase;
    }


    public static int countWordsInText(String[] textArrayForCountWords) {
        int counter = textArrayForCountWords.length;

        return counter;
    }

    public static double averageLengthOfWord(String[] array) {
        double countSymbolInWords = 0;
        for (int i = 0; i < array.length; i++) {
            countSymbolInWords += array[i].length();
        }
        double averageLenghtOnWord = countSymbolInWords / array.length;

        return averageLenghtOnWord;
    }

    public static int countNumberOfSentences(String text) {
        String[] arrayFromSentences = text.split("(?<!\\w\\.\\w.)(?<![A-Z][a-z]\\.)(?<=\\.|\\?|!)+\\s");
        int counterForSentences = arrayFromSentences.length;

        return counterForSentences;
    }

    public static double averageNumOfWordInSentences(int counterOfWords, int counterOfSentences) {
        double averageNumOfWordInSentences = (double) counterOfWords / counterOfSentences;

        return averageNumOfWordInSentences;
    }

    public static int countAllDifferentWords(String[] text) {
        HashSet<String> counterWord = new HashSet<>();

        for (String elements : text) {
            counterWord.add(elements);
        }
        HashSet<String> ignoreCase = new HashSet<>();
        for (String words : counterWord) {
            ignoreCase.add(words.toLowerCase());
        }
        int counterForSize = ignoreCase.size();

        return counterForSize;
    }

    public static int countWordsThatOccurOnlyOnce(String[] text) {
        int counter = 0;
        boolean checker = false;
        for (int i = 0; i < text.length; i++) {
            for (int j = 0; j < text.length; j++) {
                if (i == j) {
                    continue;
                } else if (!text[i].equalsIgnoreCase(text[j])) {
                    checker = true;
                } else {
                    checker = false;
                    break;
                }
            }
            if (checker) {
                counter++;
            }
        }

        return counter;
    }

    public static String returnStringFromFile(String fileName) {
        StringBuilder makeStringFromFile = new StringBuilder();
        try {
            File file = new File(fileName);
            Scanner sc = new Scanner(file, "utf-8");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                makeStringFromFile.append(line + " ");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return makeStringFromFile.toString();
    }

    public static void printResult(double AverageWodLength, double TypeTokenRatio, double HapaxLegomenaRatio, double AverageSentenceLength) {
        System.out.print("1. Avg. word length: " + AverageWodLength + "\n");
        System.out.print("2. Type-Token Ratio: " + TypeTokenRatio + "\n");
        System.out.print("3. Hapax Legomena Ratio: " + HapaxLegomenaRatio + "\n");
        System.out.print("4. Avg. sentence length: " + AverageSentenceLength + "\n");
    }

    public static void printTheWholeResult(String text1, String text2) {
        System.out.println("Text One result");
        String[] text1Array = makeArrayWithoutEmptySpace(text1);
        int countWordsTxt1 = countWordsInText(text1Array);
        double text1AverageWodLength = averageLengthOfWord(text1Array);
        double text1TypeTokenRatio = (double) countAllDifferentWords(text1Array) / countWordsTxt1;
        double text1HapaxLegomenaRatio = (double) countWordsThatOccurOnlyOnce(text1Array) / countWordsTxt1;
        int counterSentencesTxt1 = countNumberOfSentences(text1);
        double text1AverageSentenceLength = averageNumOfWordInSentences(countWordsTxt1, counterSentencesTxt1);
        printResult(text1AverageWodLength, text1TypeTokenRatio, text1HapaxLegomenaRatio, text1AverageSentenceLength);
        System.out.println("\nText Two result");
        String[] text2Array = makeArrayWithoutEmptySpace(text2);
        int countWordsTxt2 = countWordsInText(text2Array);
        double text2AverageWodLength = averageLengthOfWord(text2Array);
        double text2TypeTokenRatio = (double) countAllDifferentWords(text2Array) / countWordsTxt2;
        double text2HapaxLegomenaRatio = (double) countWordsThatOccurOnlyOnce(text2Array) / countWordsTxt2;
        int counterSentencesTxt2 = countNumberOfSentences(text2);
        double text2AverageSentenceLength = averageNumOfWordInSentences(countWordsTxt2, counterSentencesTxt2);
        printResult(text2AverageWodLength, text2TypeTokenRatio, text2HapaxLegomenaRatio, text2AverageSentenceLength);

        double plagiarismresult = (abs(text1AverageWodLength - text2AverageWodLength) * 11) + (abs(text1TypeTokenRatio - text2TypeTokenRatio) * 33) + (abs(text1HapaxLegomenaRatio - text2HapaxLegomenaRatio) * 50) + (abs(text1AverageSentenceLength - text2AverageSentenceLength) * 0.4);
        System.out.println("Similarity: " + (abs(text1AverageWodLength - text2AverageWodLength) * 11) + " + " + (abs(text1TypeTokenRatio - text2TypeTokenRatio) * 33) + " + " + (abs(text1HapaxLegomenaRatio - text2HapaxLegomenaRatio) * 50) + " + " + (abs(text1AverageSentenceLength - text2AverageSentenceLength) * 0.4) + " = " + plagiarismresult);
    }

    public static void plagiarismDetector() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("To enter text from the keyboard, press 1\nTo enter text from file, press 2");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                System.out.println("Enter your first text:");
                String text1FromKeyboard = scanner.nextLine();
                System.out.println("Enter your second text:");
                String text2FromKeyboard = scanner.nextLine();
                printTheWholeResult(text1FromKeyboard, text2FromKeyboard);
                break;
            case 2:
                System.out.println("Enter file name of first text:");
                String text1FileName = scanner.nextLine();
                String text1FromFile = returnStringFromFile(text1FileName);
                System.out.println("Enter file name of second text:");
                String text2FileName = scanner.nextLine();
                String text2FromFile = returnStringFromFile(text2FileName);
                printTheWholeResult(text1FromFile, text2FromFile);
                break;
            default:
                System.out.println("Incorrect choice! Please enter right number. 1 for text from keyboard or 2 for text from file!");
                plagiarismDetector();
        }
    }

    public static void main(String[] args) {
        plagiarismDetector();
    }
}
