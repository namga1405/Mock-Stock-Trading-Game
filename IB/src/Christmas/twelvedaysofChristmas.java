package Christmas;
import java.util.Arrays;


public class twelvedaysofChristmas {
	static String[]gifts = {"and a partridge in a pear tree", "Two turtle doves", "Three french hens","Four calling birds", "Five golden rings", "Six geese a-laying", "Seven swans a-swimming", "Eight maids a-milking", 
				"Nine ladies dancing", "Ten lords a-leaping","Eleven pipers piping", "Twelve drummers drumming" };
	static String[]numbers = {"first","second","third","fourth", "fifth", "sixth", "seventh", "eighth", "nitnth", "tenth", "eleventh", "twelveth"};

	public static void main(String[] args) {
		System.out.println("On the first day of Christmas my true love gave to me");
		System.out.println("A partridge in a pear tree");

		for (int i=1; i<12; i++) {
			System.out.println("On the " + numbers[i]+" day of Christmas my true love gave to me");
			for (int n=i; n>=0; n--) {
			System.out.println(gifts[n]);
				}
			}
		}
	}

