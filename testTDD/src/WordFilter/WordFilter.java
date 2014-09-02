package WordFilter;

import java.util.ArrayList;
import java.util.Arrays;

public class WordFilter {

	ArrayList<String> wordList;
	String replacedWord;

	/*
	 * �R���X�g���N�^
	 */
	public WordFilter() {
	}
	
	public String getReplacedWord() {
		return replacedWord;
	}

	public void setReplacedWord(String replacedWord) {
		this.replacedWord = replacedWord;
	}

	/**
	 * ������NG���܂�ł��邩���f
	 */
	public boolean detect(String string) {
		for (String word : wordList) {
			if (string.contains(word) == true) return true; 
		}
		return false;
	}

	/**
	 * ������NG���[�h���܂�ł���ꍇ�ɁA�w�肳�ꂽ�����ɕϊ�����
	 * @param string�@������
	 * @return
	 */
	public String censor(String string) {
		for (String word : wordList) {
			string = string.replace(word, replacedWord);
		}
		return string; 
	}

	/**
	 * NG���[�h�̓o�^
	 * @param string �J���}��؂�̃L�[���[�h
	 * @return
	 */
	public int registNGWord(String string) {
		wordList = new ArrayList<String>(Arrays.asList(string.split(",")));
		return wordList.size();
	}

	/**
	 * NG���[�h�̏�����
	 * @return
	 */
	public int clearNGword() {
		wordList.clear();
		return wordList.size();
	}

	/**
	 * �e�X�g���ؗp���\�b�h
	 * @return
	 */
	public ArrayList<String> getWordList() {
		// TODO Auto-generated method stub
		return wordList;
	}
}