import org.jpos.iso.ISOUtil;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.interfaces.RSAKey;
import java.security.spec.InvalidKeySpecException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KeyStoreEncryptor {
  public String rsaEncrypt(String keybyte, PublicKey publicK) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        try {
            String encryptedvalue;

            Cipher c = Cipher.getInstance("RSA");
            c.init(Cipher.ENCRYPT_MODE, publicK);
            byte[] encrypted;
            encrypted = c.doFinal(keybyte.getBytes());
            encryptedvalue = ISOUtil.hexString(encrypted);
            return encryptedvalue;

        } catch (Exception ps) {
            throw ps;
        }
    }
    
    public byte[] rsaDecrypt(byte[] keybyte, PrivateKey privateKey) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        try {
            byte[] decryptedbyte;
            Cipher c = Cipher.getInstance("RSA");
            c.init(Cipher.DECRYPT_MODE, privateKey);
            decryptedbyte = c.doFinal(keybyte);
            return decryptedbyte;
        } catch (Exception ps) {
            throw ps;
        }
    }
}
