import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.List;

public class SignatureExample {
	public static KeyPair generateKeyPair() throws NoSuchAlgorithmException {
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
		KeyPair keyPair = keyPairGen.generateKeyPair();
		return keyPair;
	}
	
	public static void writeKeyToFile(String folderPath, KeyPair keyPair) throws IOException {
		File publicKeyFile = new File(folderPath.concat("/publicKey.pem"));
		publicKeyFile.getParentFile().mkdirs();
		
		File privateKeyFile = new File(folderPath.concat("/privateKey.pem"));
		privateKeyFile.getParentFile().mkdir();

		PrintWriter publicKeyOut = new PrintWriter(publicKeyFile);
		publicKeyOut.write("-----BEGIN PUBLIC KEY-----");
		publicKeyOut.write(System.lineSeparator());
		publicKeyOut.write(Base64.getMimeEncoder().encodeToString(keyPair.getPublic().getEncoded()));
		publicKeyOut.write(System.lineSeparator());
		publicKeyOut.write("-----END PUBLIC KEY-----");
		publicKeyOut.close();
		
		PrintWriter privateKeyOut = new PrintWriter(privateKeyFile);
		privateKeyOut.write("-----BEGIN PRIVATE KEY-----");
		privateKeyOut.write(System.lineSeparator());
		privateKeyOut.write(Base64.getMimeEncoder().encodeToString(keyPair.getPrivate().getEncoded()));
		privateKeyOut.write(System.lineSeparator());
		privateKeyOut.write("-----END PRIVATE KEY-----");
		privateKeyOut.close();
	}
	
	public static byte[] sign(String data, String privateKeyFilePath) throws InvalidKeyException, Exception{
		Signature rsa = Signature.getInstance("SHA1withRSA"); 
		rsa.initSign(getPrivate(privateKeyFilePath));
		rsa.update(data.getBytes());
		return rsa.sign();
	}
	
	public static PrivateKey getPrivate(String filename) throws Exception {
		List<String> encodedKeyArray = Files.readAllLines(new File(filename).toPath());
		String encodedKey = "";
		
		encodedKeyArray.remove(0);
		encodedKeyArray.remove(encodedKeyArray.size() - 1);
		
		for (String line : encodedKeyArray) {
			encodedKey = encodedKey + line;
		}
		
		PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(Base64.getMimeDecoder().decode(encodedKey.trim()));
		KeyFactory kf = KeyFactory.getInstance("RSA");
		return kf.generatePrivate(spec);
	}
	
	private static boolean verifySignature(byte[] data, byte[] signature, String publicKeyFilePath) throws Exception {
		Signature sig = Signature.getInstance("SHA1withRSA");
		sig.initVerify(getPublic(publicKeyFilePath));
		sig.update(data);
		
		return sig.verify(signature);
	}
	
	public static PublicKey getPublic(String filename) throws Exception {
		List<String> encodedKeyArray = Files.readAllLines(new File(filename).toPath());
		String encodedKey = "";
		
		encodedKeyArray.remove(0);
		encodedKeyArray.remove(encodedKeyArray.size() - 1);
		
		for (String line : encodedKeyArray) {
			encodedKey = encodedKey + line;
		}
		
		X509EncodedKeySpec spec = new X509EncodedKeySpec(Base64.getMimeDecoder().decode(encodedKey.trim()));
		KeyFactory kf = KeyFactory.getInstance("RSA");
		return kf.generatePublic(spec);
	}

	public static void main(String[] args) throws InvalidKeyException, Exception {
		KeyPair keyPair = generateKeyPair();
		writeKeyToFile("KEYS", keyPair);
		
		String data = "YOUR DATA HERE";
		
		byte[] signedData = sign(data, "KEYS/privateKey.pem");
		boolean verifySignedData = verifySignature(data.getBytes(), signedData, "KEYS/publicKey.pem");
		
		System.out.println("Data to be Signed: " + data);
		System.out.println("Signed Data: " + Base64.getEncoder().encodeToString(signedData));
		
		if(verifySignedData)
			System.out.println("Signature successfully verified."); 
		else
			System.out.println("Signature couldn't be verified.");
	}
	
	

}
