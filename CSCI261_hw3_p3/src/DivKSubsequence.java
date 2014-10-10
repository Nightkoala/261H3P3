/*
 * DivKSubsequence.java
 * 
 * @author	Derek Brown <djb3718@rit.edu>
 * 
 * purpose	Algorithm for finding the longest subsequence of numbers where
 * 			no two consecutive elements have the same remainder when divided
 * 			by k
 */

import java.util.Scanner;

public class DivKSubsequence {
	
	// Attributes
	
	private int[] sequence;
	private int[] s;
	private int k;
	
	// Constructor
	
	public DivKSubsequence( int[] values, int k, int size ) {
		this.sequence = values;
		this.k = k;
		this.s = new int[size];
	}//end divKSubsequence constructor
	
	// Methods
	
	public int DivKAlgorithm( DivKSubsequence D ) {
		for( int j = 0 ; j < D.sequence.length ; j++ ) {
			D.s[j] = 1;
			for( int i = 0 ; i < j ; i++ ) {
				if( ( D.sequence[j]%D.k != D.sequence[i]%D.k ) && ( D.s[j] < D.s[i]+1 ) ) {
					D.s[j] = D.s[i]+1;
				}//end if
			}//end for
		}//end for
		int max = -1;
		for( int value : D.s ) {
			if( value > max ) {
				max = value;
			}//end if
		}//end for
		return max;
	}//end DivKAlgorithm

	public static void main(String[] args) {
		Scanner sc = new Scanner( System.in );
		String input = sc.next();
		int size = Integer.parseInt(input);
		int[] values = new int[size];
		input = sc.next();
		int k = Integer.parseInt(input);
		for( int i = 0 ; i < size ; i ++ ) {
			input = sc.next();
			int val = Integer.parseInt(input);
			values[i] = val;
		}//end for
		sc.close();
		DivKSubsequence D = new DivKSubsequence( values, k, size );
		int max = D.DivKAlgorithm(D);
		System.out.println(max);
	}//end main
}//end DivKSubsequence
