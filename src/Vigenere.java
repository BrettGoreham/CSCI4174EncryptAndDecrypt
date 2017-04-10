
public class Vigenere implements Cipher {
	//To see the Algebra this is based one please visit
	//https://en.wikipedia.org/wiki/Vigenere_cipher
	private String key;
	public Vigenere(String key){
		this.key = key;
	}
	public String Encrypt(String s) {
		String output="";
		for(int i =0; i<s.length(); i++){
			int keyIndex = i % key.length();
			int value = (getValue(s.charAt(i)) + getValue(key.charAt(keyIndex))) % 26;
			output += returnToChar(value);
		}
		
		return output;
	}

	public String Decrypt(String s) {
		String output="";
		for(int i =0; i<s.length(); i++){
			int keyIndex = i % key.length();
			int value = Math.floorMod(getValue(s.charAt(i)) - getValue(key.charAt(keyIndex)), 26);
			output += returnToChar(value);
		}
		return output;
	}
	
	
	public int getValue(char s){
		int val = s - 97;
		return val;
	}
	
	public char returnToChar(int x){
		return (char)(x + 97);
	}

}
