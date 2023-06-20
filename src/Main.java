import java.io.File;
import java.util.HashSet;
import java.util.Scanner;

import static java.lang.Math.abs;

public class Main {

    //метод, който създава масив от подаден текст.
    public static String[] makeArrayWithoutEmptySpace(String text) {
        String[] wordsArrayOfText = text.split("[!,(?<=\\.):\\s+]");
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

    //метод, който брои думите в даден текст.
    public static int countWordsInText(String[] textArrayForCountWords) {
        int counter = textArrayForCountWords.length;

        return counter;
    }

    //метод, който връща средната дължина на думите в даден текст
    public static double averageLenghtOfWord(String[] array) {
        double countSymbolInWords = 0;
        for (int i = 0; i < array.length; i++) {
            countSymbolInWords += array[i].length();
        }
        double averageLenghtOnWord = countSymbolInWords / array.length;

        return averageLenghtOnWord;
    }

    //метод, който брои изреченията в даден текст.
    public static int countNumberOfSentences(String text) {
        String[] arrayFromSentences = text.split("(?<!\\w\\.\\w.)(?<![A-Z][a-z]\\.)(?<=\\.|\\?|!)+\\s");
        int counterForSentences = arrayFromSentences.length;

        return counterForSentences;
    }

    //метод, който връща средният брой на думите в изречение.
    public static double averageNumOfWordInSentences(int counterOfWords, int counterOfSentences) {
        double averageNumOfWordInSentences = (double) counterOfWords / counterOfSentences;

        return averageNumOfWordInSentences;
    }

    //метод който брои всички различни думи.
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

    //метод който брои думите, които се срещат само по веднъж.
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

    public static String retrnStringFromFile(String fileName) {
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file name of first text:");
        String text1FileName = scanner.nextLine();
        String text1FromFile = retrnStringFromFile(text1FileName);
        String[] text1Array = makeArrayWithoutEmptySpace(text1FromFile);
        int countWordsTxt1 = countWordsInText(text1Array);
        double text1AverageWodLength = averageLenghtOfWord(text1Array);
        double text1TypeTokenRatio = (double) countAllDifferentWords(text1Array) / countWordsTxt1;
        double text1HapaxLegomenaRatio = (double) countWordsThatOccurOnlyOnce(text1Array) / countWordsTxt1;
        int counterSentencesTxt1 = countNumberOfSentences(text1FromFile);
        double text1AverageSentenceLength = averageNumOfWordInSentences(countWordsTxt1, counterSentencesTxt1);
        printResult(text1AverageWodLength, text1TypeTokenRatio, text1HapaxLegomenaRatio, text1AverageSentenceLength);

        System.out.println("Enter file name of second text:");
        String text2FileName = scanner.nextLine();
        String text2FromFile = retrnStringFromFile(text2FileName);
        String[] text2Array = makeArrayWithoutEmptySpace(text2FromFile);
        int countWordsTxt2 = countWordsInText(text2Array);
        double text2AverageWodLength = averageLenghtOfWord(text2Array);
        double text2TypeTokenRatio = (double) countAllDifferentWords(text2Array) / countWordsTxt2;
        double text2HapaxLegomenaRatio = (double) countWordsThatOccurOnlyOnce(text2Array) / countWordsTxt2;
        int counterSentencesTxt2 = countNumberOfSentences(text2FromFile);
        double text2AverageSentenceLength = averageNumOfWordInSentences(countWordsTxt2, counterSentencesTxt2);
        printResult(text2AverageWodLength, text2TypeTokenRatio, text2HapaxLegomenaRatio, text2AverageSentenceLength);

        double plagiarismresult = (abs(text1AverageWodLength - text2AverageWodLength) * 11) + (abs(text1TypeTokenRatio - text2TypeTokenRatio) * 33) + (abs(text1HapaxLegomenaRatio - text2HapaxLegomenaRatio) * 50) + (abs(text1AverageSentenceLength - text2AverageSentenceLength) * 0.4);
        System.out.println("Similarity: " + (abs(text1AverageWodLength - text2AverageWodLength) * 11) + " + " + (abs(text1TypeTokenRatio - text2TypeTokenRatio) * 33) + " + " + (abs(text1HapaxLegomenaRatio - text2HapaxLegomenaRatio) * 50) + " + " + (abs(text1AverageSentenceLength - text2AverageSentenceLength) * 0.4) + " = " + plagiarismresult);
    }
}