package br.com.tealdi.talkabout.helper;

import br.com.tealdi.talkabout.helper.HyphenatorImpl;
import br.com.tealdi.talkabout.helper.Hyphenator;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class HyphenatorTest {

    private Hyphenator hyphenator;

    @Before
    public void setUp() {
        hyphenator = new HyphenatorImpl();
    }

    @Test
    public void shouldHyphenateAText() {
        assertThat(hyphenator.hyphenizeIt("a text to be hyphenazed"))
    			.isEqualTo("a-text-to-be-hyphenazed");
    }
    
    @Test
    public void shouldConvertToALowercaseTextWhenHyphenating() {
    	assertThat(hyphenator.hyphenizeIt("A UPPERCASE TEXT"))
    		.isEqualTo("a-uppercase-text");
    }
    
    @Test
    public void shouldRemoveTrimHyphensWhenHyphenating() {
    	assertThat(hyphenator.hyphenizeIt("- a text - "))
    		.isEqualTo("a-text");
    }
    
    @Test
    public void shouldNotContainDoubleHyphensWhenHyphenating() {
    	assertThat(hyphenator.hyphenizeIt("- a--text - "))
    		.isEqualTo("a-text");
    }
    
    @Test
    public void shouldRemoveNonAlphanumericalCharacterWhenHyphenating() {
    	assertThat(hyphenator.hyphenizeIt("- a alphanumerical - text !@#$%^&*()_+~`'\"{}[]:;<,>.?/"))
    		.isEqualTo("a-alphanumerical-text");
    }
    
    @Test
    public void shouldConvertAccentedCharactersIntoNormalOnesWhenHyphenating() {
    	assertThat(hyphenator.hyphenizeIt("á-ãçcèñTéd-TÉxT"))
    		.isEqualTo("a-accented-text");
    }
}
