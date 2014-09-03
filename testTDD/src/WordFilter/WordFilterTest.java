package WordFilter;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

/**
 * @author miyamoto
 * �d�l
 * 1. NG���[�h�̌��o����
 * 2. NG���[�h��u������
 * 3. NG���[�h�𕡐��o�^�ł���悤�ɂ���
 * 4. �u�������𐏎��ύX�ł���悤�ɂ���
 * Content URL is #20 of http://www.slideshare.net/t_wada/tddbc-exercise
 */
public class WordFilterTest {

	WordFilter wordFilter;
	String replacedWord;
	@Before
	public void setUp() throws Exception {
		replacedWord = "�֎~����";
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
		wordFilter.registNGWord("�ӌ��");
		
		assertThat(true, is( wordFilter.detect("�����̔ӌ�т̓n���o�[�O")));
		assertThat(false, is( wordFilter.detect("�����̒����͂�̓n���o�[�O")));
		
		assertTrue(wordFilter.detect("�����̔ӌ�т̓n���o�[�O"));
		assertFalse(wordFilter.detect("�����̒����͂�̓n���o�[�O"));
	}

	@Test
	public void testCensor(){
		wordFilter.registNGWord("�n���o�[�O");
		assertThat("�����̔ӌ�т�" + replacedWord, is( equalTo( wordFilter.censor("�����̔ӌ�т̓n���o�[�O"))));
		assertThat("�����̔ӌ�т�" + replacedWord, is ( not ( equalTo( wordFilter.censor("�����̔ӌ�т̓p���o�[�O")))));		
	}
	
	@Test
	public void testRegistMultiNGWordAndCensor(){
		assertThat(2, is( wordFilter.registNGWord("�ӌ��,�n���o�[�O")));
		assertThat("������" + replacedWord + "��" + replacedWord, is( equalTo(wordFilter.censor("�����̔ӌ�т̓n���o�[�O"))));
	}

	@Test
	public void testRegistSingleNGWord(){
		assertThat(1, is( wordFilter.registNGWord("�ӌ��")));
	}
	
	@Test
	public void testCleanAndReRegistNGWord(){
		wordFilter.registNGWord("�ӌ��,�n���o�[�O");

		assertThat(0, is( wordFilter.clearNGword()));

		String[] wordList ={"����", "����g����H"};		
		wordFilter.registNGWord("����,����g����H");
		assertThat(wordList, is( arrayContaining(wordFilter.getWordList().toArray())));
	}
	
	@Test
	public void testSetReplacedWord(){
		wordFilter.setReplacedWord(replacedWord);
		assertThat(replacedWord, is( equalTo(wordFilter.getReplacedWord())));
	}
}