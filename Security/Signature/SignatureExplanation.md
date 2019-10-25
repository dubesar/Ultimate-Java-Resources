**Signature Class Explanation**

The Signature Class is used to provide applications the functionality of a digital signature algorithm. 
Digital signatures are used for authentication and integrity assurance of digital data.

To sign the data, we use a private key, and to verify the signed data, we use the public key. 
This ensure that only the owner of the data can create the signed data, and everyone who have the publicKey can verify the data.

Just to remenber, the Public Key is a key that can be disseminated widely, and commonly used to encrypt data.
The Private Key, otherwise, is a key that is known only by the owner, and is used to decrypt the data that was encrypted by the public key.


**Explanation of the code**

**generateKeyPair** → This is a function that uses a keyPairGenerator to generate a new keyPair, using the RSA algorithm.
We need the key pair to sign and verify the data.

**writeKeyToFile** → Usually, the signature is used between different systems, backends, etc. 
So, we need to split the keyPair in the privateKey file and the publicKey file. In this example, we are saving the keys 
into a PEM file, that is used for several types of data, including certificate files, and usually are just binary (DER) data encoded 
in base64 broken into lines normally every 64 chars. Then, it will create a Folder called KEYS in your project, that contains 2 PEM files: 
the privateKey.pem and the publicKey.pem.

**sign** → This is a function that receives the data and the privateKeyFilePath, creating a Signature with the SHA1withRSA algorithm. 
Then, we initialize it with our privateKey, that is in a file, so, we need to call a function to retrieve only the privateKey of this file.
With the Signature initilized with the privateKey, we call the *update()* method, to update de data to be signed, and call the *sign()* method to 
return a array of bytes containing the signedData.

**getPrivate** →  This is a function that receives the privateKeyFilePath, and read each file line to a List element. 
To obtain only the encoded privateKey, we remove the first element that is the string "-----BEGIN PRIVATE KEY-----", and remove the last element, 
that is the string "-----END PRIVATE KEY-----", and then, iterate throught the elements, to get all values to a String called encodedKey. 
With the encodedKey, we decode the Base64 and obtain the byte array of the privateKey, and create a PKCS8EncodedKeySpec, that is a private key, 
encoded according to the ASN.1 encoding. With this spec, we can call keyFactory to generate a privateKey from this spec, creating a instance 
of the privateKey saved in the file.

**verifySignature** → This is a function that receives the data, the signedData and the publicKeyFilePath, creating a Signature with the SHA1withRSA algorithm. 
Then, we initialize it with our publicKey, that is in a file, so, we need to call a function to retrieve only the publicKey of this file.
With the Signature initilized with the publicKey, we call the *update()* method, to update de data to be verifyed, and call the *verify()* method to verify if the 
signedData is the same value of the unsignedData, verify if the signedData was signed with the privateKey from the same keyPair of the publicKey, etc. 
It returns boolean result, true or false.

**getPublic** →  This is a function that receives the publicKeyFilePath, and read each file line to a List element. 
To obtain only the encoded publicKey, we remove the first element that is the string "-----BEGIN PUBLIC KEY-----", and remove the last element, 
that is the string "-----END PUBLIC KEY-----", and then, iterate throught the elements, to get all values to a String called encodedKey. 
With the encodedKey, we decode the Base64 and obtain the byte array of the publicKey, and create a X509EncodedKeySpec, that is a public key, 
encoded according to the ASN.1 encoding. With this spec, we can call keyFactory to generate a publicKey from this spec, creating a instance 
of the publicKey saved in the file.

**main** →  This is the mainfuction, that calls *generateKeyPair()* to generate the keyPair that will be used to signand verify the data. Then, it calls the
method writeKeyToFile, passing the arguments Folder, that will be saved the PEM files, and the keyPair that will be splited in 2 PEM files in the folder.
With the PEM files created, it creates the byte array signedData, that will receive the signed data, and the verifySignedData, that will be verify the signedData.
To finalize, it prints the value of the data to be signed, the signedData byte array encoded as Base64, and verify if the signedData is valid or not, 
printing the message on the screen. 
