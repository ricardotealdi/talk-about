package br.com.tealdi.talkabout.helper;

import java.text.Normalizer;

public class HyphenatorImpl implements Hyphenator {

	public String hyphenizeIt(String text) {
        return trimmingHyphens(
        		removeDuplicateHyphen(
	                removeNonCharactersButHyphen(
	                        convertSpacesIntoHyphens(
	                                removeAccents(
	                                        text.toLowerCase())))));
    }

    private static String trimmingHyphens(String text) {
        return text.replaceAll("^\\W+|\\W+$", "");
    }
    
    private static String removeDuplicateHyphen(String text) {
    	return text.replaceAll("[-]+", "-");
    }

    private static String removeAccents(String text) {
        return Normalizer
                .normalize(text, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }

    private static String removeNonCharactersButHyphen(String text) {
        return text.replaceAll("[^\\w-]|_", "");
    }

    private static String convertSpacesIntoHyphens(String text) {
        return text
                .trim()
                .replaceAll("[\\s]+", "-");
    }
}
