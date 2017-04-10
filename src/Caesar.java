
public class Caesar implements Cipher {
	private int key;
	public Caesar(int key){
		this.key = key;
	}
	public String Encrypt(String s) {		
		return addIntToChars(s.toCharArray(), key);
		
	}

	public String Decrypt(String s) {
		return addIntToChars(s.toCharArray(), (key*-1));
	}
	
	public String addIntToChars(char[] chars, int x){
		String output = "";
		for (char c : chars){
			int a = c + x;
			if(x > 0){
				while (a > 122){
					a = a - 26;
				}
			} else{
				while (a < 97){
					a = a + 26;
				}
			}
			output += (char)a;
		}
		return output;
	}

}
