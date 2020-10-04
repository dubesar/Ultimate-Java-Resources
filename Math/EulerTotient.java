public int EulerTotient( int number )
	{
		int k, divisor;
		int gcd = 1;
		int totiatives = 0;

		// Check all numbers, k, inclusively between 1 and number
		for( k = 1; k <= number; k++ )
			{
			
				// Check all divisors of k
				for( divisor = 1; divisor < k; divisor++ )
				{   
				
					// Find greatest common denominator of (n, k)
					if( k % divisor == 0 && number % divisor == 0 )
						{
							gcd = divisor;
						}
				}
		
				// If gcd is relatively prime, we have found a totient
				if( gcd == 1 )
					{
						totiatives++;
					}

			}

		return totiatives;
	}
