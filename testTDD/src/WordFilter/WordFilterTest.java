package WordFilter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author miyamoto
 * 仕様
 * 1. NGワードの検出する
 * 2. NGワードを置換する
 * 3. NGワードを複数登録できるようにする
 * Content URL is #20 of http://www.slideshare.net/t_wada/tddbc-exercise
 */
public class WordFilterTest {

	WordFilter wordFilter;
	@Before
	public void setUp() throws Exception {
		wordFilter = new WordFilter();
	}
	
	@Test
	public void testDetectSimpleWord(){
		wordFilter.registNGWord("aaa");
		assertTrue(wordFilter.detect("aaa bbb"));
		assertFalse(wordFilter.detect("aabbbaa"));
	}

	@Test
	public void testDetectWordInSentence(){
		wordFilter.registNGWord("晩御飯");
		assertTrue(wordFilter.detect("今日の晩御飯はハンバーグ"));
		assertFalse(wordFilter.detect("今日の昼ごはんはハンバーグ"));
	}

	@Test
	public void testCensor(){
		wordFilter.registNGWord("ハンバーグ");
		assertEquals("今日の晩御飯は<censored>", wordFilter.censor("今日の晩御飯はハンバーグ"));
		assertNotEquals("今日の晩御飯は<censored>", wordFilter.censor("今日の晩御飯はパンバーグ"));
	}
	
	@Test
	public void testRegistMultiNGWordAndCensor(){
		WordFilter wordFilter = new WordFilter();
		assertEquals(2, wordFilter.registNGWord("晩御飯,ハンバーグ"));
		assertEquals("今日の<censored>は<censored>", wordFilter.censor("今日の晩御飯はハンバーグ"));
	}

	@Test
	public void testRegistSingleNGWord(){
		WordFilter wordFilter = new WordFilter();
		assertEquals(1, wordFilter.registNGWord("晩御飯"));
	}
	
	@Test
	public void testCleanAndReRegistNGWord(){
		wordFilter.registNGWord("晩御飯,ハンバーグ");
		assertEquals(0, wordFilter.clearNGword());

		String[] wordList ={"お昼", "から揚げ定食"}; 
		wordFilter.registNGWord("お昼,から揚げ定食");
		assertArrayEquals(wordList, wordFilter.getWordList().toArray());
	}
}