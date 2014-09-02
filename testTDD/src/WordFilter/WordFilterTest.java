package WordFilter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author miyamoto
 * �d�l
 * 1. ���蕶����̌��o����
 * 2. ���蕶�����u������
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
		WordFilter wordFilter = new WordFilter("�ӌ��");
		assertTrue(wordFilter.detect("�����̔ӌ�т̓n���o�[�O"));
		assertFalse(wordFilter.detect("�����̒����͂�̓n���o�[�O"));
	}

	@Test
	public void testCensor(){
		WordFilter wordFilter = new WordFilter("�n���o�[�O");
		assertEquals("�����̔ӌ�т�<censored>", wordFilter.censor("�����̔ӌ�т̓n���o�[�O"));
		assertNotEquals("�����̔ӌ�т�<censored>", wordFilter.censor("�����̔ӌ�т̓p���o�[�O"));
	}
}