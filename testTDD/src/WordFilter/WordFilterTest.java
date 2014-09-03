package WordFilter;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

/**
 * @author miyamoto
 * 仕様
 * 1. NGワードの検出する
 * 2. NGワードを置換する
 * 3. NGワードを複数登録できるようにする
 * 4. 置換文字を随時変更できるようにする
 * Content URL is #20 of http://www.slideshare.net/t_wada/tddbc-exercise
 */
public class WordFilterTest {

	WordFilter wordFilter;
	String replacedWord;
	@Before
	public void setUp() throws Exception {
		replacedWord = "禁止文字";
		wordFilter = new WordFilter();
		wordFilter.setReplacedWord(replacedWord);
	}
	
	@Test
	public void testDetectSimpleWord(){
		wordFilter.registNGWord("aaa");
		
		assertThat(true, is( wordFilter.detect("aaa bbb")));
		assertThat(false, is( wordFilter.detect("aabbbaa")));
		
		assertTrue(wordFilter.detect("aaa bbb"));
		assertFalse(wordFilter.detect("aabbbaa"));
	}

	@Test
	public void testDetectWordInSentence(){
		wordFilter.registNGWord("晩御飯");
		
		assertThat(true, is( wordFilter.detect("今日の晩御飯はハンバーグ")));
		assertThat(false, is( wordFilter.detect("今日の昼ごはんはハンバーグ")));
		
		assertTrue(wordFilter.detect("今日の晩御飯はハンバーグ"));
		assertFalse(wordFilter.detect("今日の昼ごはんはハンバーグ"));
	}

	@Test
	public void testCensor(){
		wordFilter.registNGWord("ハンバーグ");
		assertThat("今日の晩御飯は" + replacedWord, is( equalTo( wordFilter.censor("今日の晩御飯はハンバーグ"))));
		assertThat("今日の晩御飯は" + replacedWord, is ( not ( equalTo( wordFilter.censor("今日の晩御飯はパンバーグ")))));		
	}
	
	@Test
	public void testRegistMultiNGWordAndCensor(){
		assertThat(2, is( wordFilter.registNGWord("晩御飯,ハンバーグ")));
		assertThat("今日の" + replacedWord + "は" + replacedWord, is( equalTo(wordFilter.censor("今日の晩御飯はハンバーグ"))));
	}

	@Test
	public void testRegistSingleNGWord(){
		assertThat(1, is( wordFilter.registNGWord("晩御飯")));
	}
	
	@Test
	public void testCleanAndReRegistNGWord(){
		wordFilter.registNGWord("晩御飯,ハンバーグ");

		assertThat(0, is( wordFilter.clearNGword()));

		String[] wordList ={"お昼", "から揚げ定食"};		
		wordFilter.registNGWord("お昼,から揚げ定食");
		assertThat(wordList, is( arrayContaining(wordFilter.getWordList().toArray())));
	}
	
	@Test
	public void testSetReplacedWord(){
		wordFilter.setReplacedWord(replacedWord);
		assertThat(replacedWord, is( equalTo(wordFilter.getReplacedWord())));
	}
}