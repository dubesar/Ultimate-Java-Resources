**Key Pair Class Explanation**

The Key Pair Class is a simple holder for a key pair (a public key and a private key). 

But what is a public key and a private key?

The Public Key is a key that can be disseminated widely, and commonly used to encrypt data.

The Private Key, otherwise, is a key that is known only by the owner, and is used to decrypt the data that was encrypted by the public key.


The class have one constructor and two methods:

Constructor:

KeyPair(PublicKey publicKey, PrivateKey privateKey)
Constructs a key pair from the given public key and private key.

Methods:

getPrivate()
Returns a reference to the private key component of this key pair.

getPublic()
Returns a reference to the public key component of this key pair.


**Explanation of the code**

**main** →  This is a function that uses a keyPairGenerator to generate a new keyPair, using the RSA algorithm. 
With the new keyPair, wet get the PrivateKey and the PublicKey to make encrypt and decrypt operations.

**encrypt** → This is a function that receives the data to be encrypted and the public key. 
Then, we create a Cipher, using the RSA algorithm, and use the public key to encrypt the data. 
The result is returned in bytes, to display it in System.out, we encode it in Base64.

**decrypt** → This is a function that receives the data to be decrypted and the private key. 
Then, we decode the Base64 encrypted data, and create a Cipher, using the RSA algorithm, and use the private key to decrypt the data. 
The result is returned in bytes, to display it in System.out, we create a new String.