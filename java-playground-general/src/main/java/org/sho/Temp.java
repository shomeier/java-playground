package org.sho;

import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.Supplier;
import java.util.function.Consumer;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class Temp {
    public static void main(String[] args) {


        // as the 'throw' statement is not an expression (but a statement) it needs curly braces
        // https://stackoverflow.com/questions/41961392/why-does-a-java-lambda-which-throws-a-runtime-exception-require-brackets
        //
        Consumer<String> c = s -> { throw new RuntimeException();};

        Supplier<String> testSupplier = () -> { return "test"; };
        System.out.println("Test Supplier: %s".formatted(testSupplier.get()));

        final String test;
        test = "test";
        System.out.println("Test: %s".formatted(test));

        // castTest("1");
        // stripIndent("H \nB");
        testLocalDateTimeNowFormat();
    }

    private static void testLocalDateTimeNowFormat() {

        final String datePattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
        OffsetDateTime now = OffsetDateTime.now();
        System.out.println("Now: " + now.format(DateTimeFormatter.ofPattern(datePattern)));
    }

    public static void misc() {


        Locale en = Locale.forLanguageTag("en");

        Locale gb = Locale.forLanguageTag("de-Latn-CH-1996");
        String language = gb.getLanguage();
        String country = gb.getCountry();
        String languageTag = gb.toLanguageTag();
        Locale ext = Locale.forLanguageTag("en-Latn-GB-boont-r-extended-sequence-x-private");
        boolean hasExtensions = ext.hasExtensions();


        Locale us = Locale.forLanguageTag("en-US");


        var range = new Locale.LanguageRange("en");
        Locale.lookup(null, null);

        Map<String, ? extends Collection<? extends Number>> test = test();

        Collection<? extends Number> collection = test.get("test");

        // valid variable
        Long $te€st$3 = 0L;

        short s = 1;
        long l = 1;
        var v = 1;

        Long value = null;

        try {
            if (value instanceof Long) {
                System.out.println("Instance of Long !!!");
            }
        } catch (NullPointerException e) {
            System.out.println("NPE!!!");
        }


        // long value = 100;
        // float value = 102.0;

        // Files.delete(Paths.get("/Users/shomeier/dev/temp/sync/test08/Transfer/CMIS_Test_FOR/apollon_Logo_Claim.jpg"));

        // File myFile = new File(new
        // URI("file:///Users/shomeier/dev/temp/sync/test08/Documents/PDF/pdf-type-file.pdf"));

        // boolean delete = myFile.delete();
        // System.out.println("Coudl delete: " + delete);


    }

    private static Map<String, ? extends Collection<? extends Number>> test() {

        return new HashMap<>();
    }

    private static void varInstanceOf() {

        // 10 (int) can not be cast to String, therefore the error
        // see also here: https://stackoverflow.com/a/2551821/2808929
        // var k = 10 instanceof String;
    }

    private static <T> void castTest(T obj) {

        var test = (Long) obj;
        System.out.println("Test: " + test);
    }

    private static void stripIndent(final String test) {

        String stripIndented = test.stripIndent();
        System.out.println("test Length: " +  test.length());
        System.out.println("StripIndented: " + stripIndented);
        System.out.println("StripIndented Length: " +  stripIndented.length());
    }
}
