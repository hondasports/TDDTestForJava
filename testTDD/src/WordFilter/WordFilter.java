package WordFilter;

import java.util.ArrayList;
import java.util.Arrays;

public class WordFilter {

	ArrayList<String> wordList;
	String replacedWord;

	/*
	 * コンストラクタ
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
	 * 文字列がNGを含んでいるか判断
	 */
	public boolean detect(String string) {
		for (String word : wordList) {
			if (string.contains(word) == true) return true; 
		}
		return false;
	}

	/**
	 * 文字列がNGワードを含んでいる場合に、指定された文字に変換する
	 * @param string　文字列
	 * @return
	 */
	public String censor(String string) {
		for (String word : wordList) {
			string = string.replace(word, replacedWord);
		}
		return string; 
	}

	/**
	 * NGワードの登録
	 * @param string カンマ区切りのキーワード
	 * @return
	 */
	public int registNGWord(String string) {
		wordList = new ArrayList<String>(Arrays.asList(string.split(",")));
		return wordList.size();
	}

	/**
	 * NGワードの初期化
	 * @return
	 */
	public int clearNGword() {
		wordList.clear();
		return wordList.size();
	}

	/**
	 * テスト検証用メソッド
	 * @return
	 */
	public ArrayList<String> getWordList() {
		// TODO Auto-generated method stub
		return wordList;
	}
}