public class Main {

    public static void main(String args[]){

        System.out.println(ArraysAndStrings.replaceSubstring(
                "This is a test."," ", "%20"));

        System.out.println(ArraysAndStrings.replaceSubstring(
                ""," ", "%20"));

        System.out.println(ArraysAndStrings.replaceSubstring(
                "This is a test.","SOMETHING MUCH LONGER THAN BEFOREJ ", "%20"));


        System.out.println(ArraysAndStrings.replaceSubstring(
                "I love apples apples are great. Yay apples. ","apples", "oranges"));
        System.out.println(ArraysAndStrings.replaceSubstring(

                " "," ", "%20"));
        System.out.println(ArraysAndStrings.replaceSubstring(
                "with a space at the end "," ", "%20"));
    }
}
