package WordFilter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author miyamoto
 * �d�l
 * 1. NG���[�h�̌��o����
 * 2. NG���[�h��u������
 * 3. NG���[�h�𕡐��o�^�ł���悤�ɂ���
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
		wordFilter.registNGWord("�ӌ��");
		assertTrue(wordFilter.detect("�����̔ӌ�т̓n���o�[�O"));
		assertFalse(wordFilter.detect("�����̒����͂�̓n���o�[�O"));
	}

	@Test
	public void testCensor(){
		wordFilter.registNGWord("�n���o�[�O");
		assertEquals("�����̔ӌ�т�<censored>", wordFilter.censor("�����̔ӌ�т̓n���o�[�O"));
		assertNotEquals("�����̔ӌ�т�<censored>", wordFilter.censor("�����̔ӌ�т̓p���o�[�O"));
	}
	
	@Test
	public void testRegistMultiNGWordAndCensor(){
		WordFilter wordFilter = new WordFilter();
		assertEquals(2, wordFilter.registNGWord("�ӌ��,�n���o�[�O"));
		assertEquals("������<censored>��<censored>", wordFilter.censor("�����̔ӌ�т̓n���o�[�O"));
	}

	@Test
	public void testRegistSingleNGWord(){
		WordFilter wordFilter = new WordFilter();
		assertEquals(1, wordFilter.registNGWord("�ӌ��"));
	}
	
	@Test
	public void testCleanAndReRegistNGWord(){
		wordFilter.registNGWord("�ӌ��,�n���o�[�O");
		assertEquals(0, wordFilter.clearNGword());

		String[] wordList ={"����", "����g����H"}; 
		wordFilter.registNGWord("����,����g����H");
		assertArrayEquals(wordList, wordFilter.getWordList().toArray());
	}
}