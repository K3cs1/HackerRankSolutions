package datastructures.twodimarray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Solution {

	private static final int HOURGLASS_ROW_SIZE = 3;
	private static final int HOURGLASS_COL_SIZE = 3;

	public static void main( String[] args ) throws IOException {
		BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( System.in ) );

		List<List<Integer>> arr = new ArrayList<>();

		IntStream.range( 0, 6 ).forEach( i -> {
			try {
				arr.add(
						Stream.of( bufferedReader.readLine().replaceAll( "\\s+$", "" ).split( " " ) )
								.map( Integer::parseInt )
								.collect( toList() )
				);
			} catch ( IOException ex ) {
				throw new RuntimeException( ex );
			}
		} );

		/*
		Test Data
		 */
//		arr.add( Arrays.asList( 1, 1, 1, 0, 0, 0 ) );
//		arr.add( Arrays.asList( 0, 1, 0, 0, 0, 0 ) );
//		arr.add( Arrays.asList( 1, 1, 1, 0, 0, 0 ) );
//		arr.add( Arrays.asList( 0, 0, 2, 4, 4, 0 ) );
//		arr.add( Arrays.asList( 0, 0, 0, 2, 0, 0 ) );
//		arr.add( Arrays.asList( 0, 0, 1, 2, 4, 0 ) );
		// [7, 19] -> 19

//		arr.add( Arrays.asList( 0, 1, 2, 3, 0, 0 ) );
//		arr.add( Arrays.asList( 0, 0, 4, 0, 0, 0 ) );
//		arr.add( Arrays.asList( 0, 1, 1, 3, 0, 0 ) );
//		arr.add( Arrays.asList( 0, 0, 0, 2, 4, 4 ) );
//		arr.add( Arrays.asList( 0, 0, 0, 0, 2, 0 ) );
//		arr.add( Arrays.asList( 0, 0, 0, 1, 4, 3 ) );
		// [15, 20] -> 20

//		arr.add( Arrays.asList( 1, 1, 1, 0, 0, 0 ) );
//		arr.add( Arrays.asList( 0, 1, 0, 0, 0, 0 ) );
//		arr.add( Arrays.asList( 1, 1, 1, 0, 0, 0 ) );
//		arr.add( Arrays.asList( 0, 9, 2, -4, -4, 0 ) );
//		arr.add( Arrays.asList( 0, 0, 0, -2, 0, 0 ) );
//		arr.add( Arrays.asList( 0, 0, -1, -2, -4, 0 ) );
		// -> 13

		System.out.println( getBiggestHourglass( arr ) );
		bufferedReader.close();
	}

	private static int getBiggestHourglass( List<List<Integer>> hourglasses ) {
		int maxHourglass = Integer.MIN_VALUE;
		for ( int row = 0; row < hourglasses.size(); row++ ) {
			for ( int col = 0; col < hourglasses.get( row ).size(); col++ ) {
				if ( row <= HOURGLASS_ROW_SIZE && col <= HOURGLASS_COL_SIZE ) {
					int tempHourglassSize = hourglasses.get( row ).get( col ) +
							hourglasses.get( row ).get( col + 1 ) +
							hourglasses.get( row ).get( col + 2 ) +
							hourglasses.get( row + 1 ).get( col + 1 ) +
							hourglasses.get( row + 2 ).get( col ) +
							hourglasses.get( row + 2 ).get( col + 1 ) +
							hourglasses.get( row + 2 ).get( col + 2 );
					if ( tempHourglassSize > maxHourglass ) {
						maxHourglass = tempHourglassSize;
					}
				}
			}
		}
		return maxHourglass;
	}

}