package br.com.tealdi.talkabout.helper;

import com.google.inject.ImplementedBy;

@ImplementedBy(HyphenatorImpl.class)
public interface Hyphenator {

	public abstract String hyphenizeIt(String text);

}