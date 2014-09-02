package WordFilter;

import java.util.ArrayList;
import java.util.Arrays;

public class WordFilter {

	ArrayList<String> wordList;

	public WordFilter() {
		// TODO Auto-generated constructor stub
	}

	public boolean detect(String string) {
		for (String word : wordList) {
			if (string.contains(word) == true) return true; 
		}
		return false;
	}

	public String censor(String string) {
		for (String word : wordList) {
			string = string.replace(word, "<censored>");
		}
		return string; 
	}

	public int registNGWord(String string) {
		wordList = new ArrayList<String>(Arrays.asList(string.split(",")));
		return wordList.size();
	}

	public int clearNGword() {
		wordList.clear();
		return wordList.size();
	}

	public ArrayList<String> getWordList() {
		// TODO Auto-generated method stub
		return wordList;
	}
}