package arrays;

public class CaesarCipher {

	protected char[] encoder = new char[26];
	protected char[] decoder = new char[26];

	public CaesarCipher(int rotation) {
		for (int k = 0; k < 26; k++) {
			encoder[k] = (char) ('A' + (rotation + k) % 26);
			decoder[k] = (char) ('A' + (26 - rotation + k) % 26);
		}
	}
	
	public String encrypt(String message) {
		return tranform(message,encoder);
	}
	
	public String decrypt(String message) {
		return tranform(message,decoder);
	}

	private String tranform(String original, char[] code) {
		char[] msg = original.toCharArray();
		
		for (int i = 0; i < msg.length; i++) {
			if(Character.isUpperCase(msg[i])) {
				int j = msg[i] - 'A';
				msg[i] = code[j];
			}
		}

		return new String(msg);
	}

}
