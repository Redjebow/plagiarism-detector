public class Main {
    //Метод, който принтира масив.
    public static void printArray(String[]stringArray){
        for (int i = 0; i < stringArray.length; i++) {
            System.out.print(stringArray[i]+", ");
        }
    }
    //метод, който създава масив от подаден текст.
    public static String[] makeArrayWithoutEmptySpace(String text){
        String [] wordsArrayOfText = text.split("[!,(?<=\\.)\\s+]");
        int emptySpace = 0;
        for (int i = 0; i < wordsArrayOfText.length; i++) {
            if("".equalsIgnoreCase(wordsArrayOfText[i])){
                emptySpace++;
            }
        }
        String [] wordsArrayOfTextWidaltEmptySpase = new String[wordsArrayOfText.length-emptySpace];
        int index=0;
        for (int i = 0; i < wordsArrayOfText.length; i++) {
            if(!wordsArrayOfText[i].isEmpty()){
                wordsArrayOfTextWidaltEmptySpase[index]=wordsArrayOfText[i];
                index++;
            }
        }
        return wordsArrayOfTextWidaltEmptySpase;
    }
    //метод, който брои думите в даден текст.
    public static int countWordsInText(String[] textArrayForCountWords){
        int counter = textArrayForCountWords.length;
        return counter;
    }
    //метод, който връща средната дължина на думите в даден текст
    public static double averageLenghtOfWord(String [] array){
        int countSymbolInWords=0;
        double averageLenghtOnWord=0;
        for (int i = 0; i < array.length; i++) {
            countSymbolInWords+=array[i].length();
        }
        averageLenghtOnWord=countSymbolInWords/array.length;
        return averageLenghtOnWord;
    }
    //метод, който брои изреченията в даден текст.
    public static int countNumberOfSentences(String text){

        String[]arrayFromSentences =text.split("(?<!\\w\\.\\w.)(?<![A-Z][a-z]\\.)(?<=\\.|\\?|!)\\s");
        int counterForSentences = arrayFromSentences.length;
        return counterForSentences;
    }
    //метод, който връща средният брой на думите в изречение.
    //08.06.23
    public static double averageNumOfWordInSentences(int counterOfWords, int counterOfSentences){
        double averageNumOfWordInSentences = counterOfWords/counterOfSentences;
        return averageNumOfWordInSentences;
    }
    public static void main(String[] args) {
        String text1="Hello world! my name is redzheb redzhebov. i living the dark, dark is my home. Hello world! my name is redzheb redzhebov. i living the dark, dark is my home.";
        String[] text1Array = makeArrayWithoutEmptySpace(text1);
        int countWordsTxt1=countWordsInText(text1Array);
        System.out.println("Count words txt1: "+countWordsTxt1);
        double text1AverageLenghtOfWord = averageLenghtOfWord(text1Array);
        System.out.println("text1AverageLenghtOfWord: "+text1AverageLenghtOfWord);
        int counterSentencesTxt1 = countNumberOfSentences(text1);
        System.out.println("counterSentencesTxt1: "+counterSentencesTxt1);
        double text1AverageNumOfWordInSentences = averageNumOfWordInSentences(countWordsTxt1, counterSentencesTxt1 );
        System.out.println("text1AverageNumOfWordInSentences: "+text1AverageNumOfWordInSentences);


        String text2="Hello world! my name is redzheb redzhebov. i living the dark, dark is my home";
        String[] text2Array = makeArrayWithoutEmptySpace(text2);
        int countWordsTxt2=countWordsInText(text2Array);
        System.out.println("Count words txt2: "+countWordsTxt2);
        double text2AverageLenghtOfWord = averageLenghtOfWord(text2Array);
        System.out.println("text2AverageLenghtOfWord: "+text2AverageLenghtOfWord);
        int counterSentencesTxt2 = countNumberOfSentences(text2);
        System.out.println("counterSentencesTxt2: "+counterSentencesTxt2);
        double text2AverageNumOfWordInSentences = averageNumOfWordInSentences(countWordsTxt2, counterSentencesTxt2 );
        System.out.println("text1AverageNumOfWordInSentences: "+text2AverageNumOfWordInSentences);



    }
}