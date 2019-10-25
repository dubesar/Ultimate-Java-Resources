import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class KeyPairExample {

	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException,
			IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException {
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");

		KeyPair keyPair = keyPairGen.generateKeyPair();
		PrivateKey pvKey = keyPair.getPrivate();
		PublicKey pbKey = keyPair.getPublic();

		String encryptedData = encrypt("Your Name", pbKey);
		String decryptedData = decrypt(encryptedData, pvKey);
		System.out.println("Encrypted Data: " + encryptedData);
		System.out.println("Decrypted Data: " + decryptedData);
	}

	public static String encrypt(String data, PublicKey pbKey) throws InvalidKeyException, NoSuchAlgorithmException,
			NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, pbKey);

		byte[] encryptedBytes = cipher.doFinal(data.getBytes());
		return Base64.getEncoder().encodeToString(encryptedBytes);
	}

	public static String decrypt(String data, PrivateKey pvKey)
			throws InvalidKeySpecException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		byte[] dataToDecrypt = Base64.getDecoder().decode(data);

		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, pvKey);
		
		return new String(cipher.doFinal(dataToDecrypt));
	}

}
