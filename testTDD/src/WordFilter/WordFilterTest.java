package WordFilter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author miyamoto
 * 仕様
 * 1. 特定文字列の検出する
 * 2. 特定文字列を置換する
 * Content URL is #20 of http://www.slideshare.net/t_wada/tddbc-exercise
 */
public class WordFilterTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testInitializeWithParam(){
		String testString = "aaa";
		WordFilter wordFilter = new WordFilter(testString);

		assertNotNull(wordFilter);
		assertEquals(testString,wordFilter.getWord());
	}
	
	@Test
	public void testDetectSimpleWord(){
		WordFilter wordFilter = new WordFilter("aaa");
		assertTrue(wordFilter.detect("aaa bbb"));
		assertFalse(wordFilter.detect("aabbbaa"));
	}
	
	@Test
	public void testDetectWordInSentence(){
		WordFilter wordFilter = new WordFilter("晩御飯");
		assertTrue(wordFilter.detect("今日の晩御飯はハンバーグ"));
		assertFalse(wordFilter.detect("今日の昼ごはんはハンバーグ"));
	}

	@Test
	public void testCensor(){
		WordFilter wordFilter = new WordFilter("ハンバーグ");
		assertEquals("今日の晩御飯は<censored>", wordFilter.censor("今日の晩御飯はハンバーグ"));
		assertNotEquals("今日の晩御飯は<censored>", wordFilter.censor("今日の晩御飯はパンバーグ"));
	}
}