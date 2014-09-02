package WordFilter;

public class WordFilter {

	String word;

	public String getWord() {
		return word;
	}

	public WordFilter(String string) {
		word = string;
	}

	public boolean detect(String string) {
		return string.contains(word);
	}

	public String censor(String string) {
		return string.replace(word, "<censored>");
	}
}