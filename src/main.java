import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class main {
	public static void main(String[] args){
		 Scanner scanner = new Scanner(System.in);	
		 
		 System.out.println("Please input encryption type");
		 System.out.println("Pick one of C, V, or M");
		 System.out.print("Caesar, Vigenere, or Matrix Transposition: ");
		 String encryptionType = scanner.nextLine();
		 
		 while (!encryptionType.equals("C") && !encryptionType.equals("V") 
				 && !encryptionType.equals("M")){
			 System.out.print("Please enter either C, V, or M: ");
			 encryptionType = scanner.nextLine();
		 }
		 Cipher cipher = new Caesar(0);// does nothing with int 0; base cipher
		 
		 if(encryptionType.equals("C")){
			 System.out.print("Please input key for Caesar Cipher (int): ");
			 int key = scanner.nextInt();
			 cipher = new Caesar(key);
			 scanner.nextLine();
		 }
		 if(encryptionType.equals("V")){
			 System.out.print("Please input key for Vigenere Cipher (String Lowercase): ");
			 String key = scanner.nextLine();
			 cipher = new Vigenere(key);
		 }
		 if(encryptionType.equals("M")){
			 System.out.print("Please input key for Matrix Tranposition Cipher (x,x,x,x): ");
			 String key = scanner.nextLine();
			 String[] stringkey = key.split(",");
			 ArrayList<Integer> keys = new ArrayList<Integer>();
			 for(String s : stringkey){
				 keys.add(Integer.parseInt(s));
			 }
			 cipher = new MatrixTransposition(keys);
		 }
		 
		 
		 while(true){
			 System.out.print("encrypt, decrypt, or exit: ");
			 String function = scanner.nextLine();
			 
			 if(function.equals("exit")){
				 break;
			 }
			 
			 if(function.equals("encrypt")){
				 System.out.print("Text to encrypt (lowercase): ");
				 String text = scanner.nextLine();
				 System.out.println("Encrypted Text: " + cipher.Encrypt(text));
			 }
			 
			 if(function.equals("decrypt")){
				 System.out.print("Text to decrypt (lowercase): ");
				 String text = scanner.nextLine();
				 System.out.println("Decrypted Text: " + cipher.Decrypt(text));
			 }
		 }
	}
}
