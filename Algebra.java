// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	        // Tests some of the operations
	   	System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));

	}  


	
	public static int negativeToPositive(int x)
	{
		return (minus(0,x));
	}


	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int sum=x1;
		if(x2>=0)
		{
			for (int i=0;i<x2;i++)
			{
				sum++;
			}
		}
		else
		{
			for (int i=0; i>x2 ;i--)
			{
				sum--;
			}
		}
		return sum;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int difference=x1;
		
		if (x2>=0)
		{
			for (int i=0;i< x2;i++)
			{
				difference--;
			}
		}
		else 
		{
			for (int i=0; i>x2; i--)
				{
					difference++;
				}
		}
		return difference;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int result=x1;
		int n1=x1;
		int n2=x2;
		boolean isPositive= true;
		
		if(x1==0 | x2==0)
		{
			return 0;
		}
		if(x1<0)
		{
			n1=negativeToPositive(x1);
			isPositive=!isPositive;
			result=n1;
		}
		if (n2<0)
		{
			n2=negativeToPositive(x2);
			isPositive=!isPositive;
		}
		for (int i=1; i<n2;i++)
		{
			result= plus(result,n1);
		}
			if (isPositive)
			{
				return result;
			}
			else
			{
				return minus(0,result);
			}
	
		
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int result=x;
		if (n==0)
		{
			return 1;
		}
			for (int i=1; i<n;i++)
			{
				result=times(result,x);
			}
			return result;
		
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int result=x1;
		int n1=x1;
		int n2=x2;
		int count=0;
		boolean isPositive=true;
		if (x1<0)
		{
			n1=negativeToPositive(x1);
			isPositive=!isPositive;
			result=n1;
		}
		if (x2<0)
		{
			n2=negativeToPositive(x2);
			isPositive=!isPositive;
		}
		while (result>=n2)
		{
			result=minus(result,n2);
			count++;
		}
		if (isPositive)
		{
			return count;
		}
		else
		{
			return minus(0,count);
		}
		
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int div=div(x1,x2);
		int times=times(x2,div);
		int result=minus(x1,times);
		return result;

	}	

	// Returns the integer part of sqrt(x) 
		public static int sqrt(int x) {

			if(x==0 || x==1)
		{
			return x;
		}

		int num=x;
		int epsilon=1;
		int g= div(num,2) ;
		if (g==0)
		{
			g=1;
		}
		int tempG=-1;
		

		//(minus(times(g,g),num)>epsilon)
		while (true) 
		{
			if(minus(0,epsilon)<= minus(x,times(g,g)) && minus(x,times(g,g))<= epsilon )
				{
					break;
				} 
				if(g==0)
				{
					break;
				}
			tempG=g;
			g= minus(g,div(minus(times(g,g),x),times(2,g)));
			if (tempG==g)
			{
				break;
			}
		}

		while (times(g,g)> x)
		{
			g--;
		}
		return g;
	}	  	  
}