#SECURE RANDOM CLASS
Secure Random class provides a cryptographically strong random number generator. It produces random values by using a cryptographically strong pseudo-random number generator (CSPRNG).

###Generating Random Values
The most common way of using _SecureRandom_ is to generate int, long, float, double or boolean values. It happens with usage of method **next** with suitable type f.ex. **nextInt()** or **nextLong()**.
In addition for generating int values we can pass an upper bound as a parameter:

`int randomInt = secureRandom.nextInt(upperBound);`

What is more _SecureRandom_ is giving us possibility to generate a **stream** of values for int, double and long.

`LongStream randomLongStream = secureRandom.longs();`

For all streams we can explicity set th stream _size_, _origin_ (inclusive) and _bound_(exclusive) values:

`IntStream intStream = secureRandom.ints(streamSize, originValue, boundValue);`

Also we can generate **sequence** of random bytes, by using **nextBytes()** method. We need to provide byte array and function fills it with random bytes.

`byte[] values = new byte[124];
secureRandom.nextByte(values);`

###Specifing Random Number Generator (RNG)
By default, SecureRandom uses the **SHA1PRNG algorithm** to generate random values. Of course, nothing bans us from changing it.
To do this you need to invoke **getInstance** method. It returns a SecureRandom object that implements the specified RNG algorithm.

`getProvider()` method returns the provider of this SecureRandom object. The list of providers is given after `Security.getProviders()` call.

`getInstance(String algorithm)` - returns a SecureRandom object which implements the specified RNG algorithm. The method is going through the list of registered security Providers, starting with the most prefered one. 
A new SecureRandom object is encapsulating the SecureRandomSpi implementation from the first Provider that supports the specified algorithm is returned. 

`getInstance(String algorithm, String provider)` - this also returns a SecureRandom object, but it's encapsulating the SecureRandomSpi implementation from the specified provider.
Provider must be registered in the provider's list.

`getInstance(String algorithm, Procider provider)` - this method differs a little bit from the previous one. While using it the Provider object you are using does not need to be registered in the provider's list.

Creating `new SecureRandom()` is equivalent to `SecureRandom.getInstance("SHA1PRNG")`

###Seeds
Every instance of SecureRandom is created with an initial seed. Seed is the starting point in generating random numbers. It works as a base for providing random values and changes every time we generate a new value.

When you are calling new instance of SecureRandom by using new operator or `SecureRandom.getInstance()` you are taking the default seed from `/dev/urandom` file.

You can change the seed by passing it in a constructor parameter or by invoking a setter method on created object.

`#by constructor
byte[] seed = getSecureRandomSeed();
SecureRandom secureRandom = new SecureRandom(seed);`

`#by setter method
byte [] seed = getSecureRandomSeed();
secureRandom.setSeed(seed);`

What is worth remembering is that when you create two instances of SecureRandom with the same seed, you can get the same sequence of method calls for them and with that both instances will generate and return identical sequences of numbers.