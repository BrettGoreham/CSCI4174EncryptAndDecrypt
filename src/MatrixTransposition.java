import java.util.List;


public class MatrixTransposition implements Cipher {
	List<Integer> key;

	public MatrixTransposition(List<Integer> key){
		this.key = key;
	}
	
	public String Encrypt(String s) {
		int size = key.size();
		int rows = (int) Math.ceil(s.length() / (double)size);
		
		char[][] matrix = new char[size][rows];
		
		for(int i =0; i < s.length(); i ++){
			int row = i / size;
			int column = i % size;
			matrix[column][row] = s.charAt(i);
		}
		
		String output = "";
		for (int keyIndex : key){
			for(int i = 0; i < rows; i++){
				output += matrix[keyIndex-1][i];
			}
		}
		return output;
	}

	public String Decrypt(String s) {
		int size = key.size();
		while(s.length()%size != 0 ){
			s += " ";
		}
		int rows = (int) Math.ceil(s.length() / (double)size);
		
		char[][] matrix = new char[size][rows];
		
		int count = 0;
		for(int keyIndex : key){
			for(int i = 0; i < rows; i++){
				matrix[keyIndex-1][i] = s.charAt(count);
				count++;
			}
		}
		String output = "";
		for (int i = 0; i < rows; i++){
			for(int j = 0; j <size; j++){
				output += matrix[j][i];
			}
		}
		return output;
	}

}
