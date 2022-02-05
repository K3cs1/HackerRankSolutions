package com.morganstanley.smallestnegativebalance;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SmallestNegativeBalance {

	private final static String NOBODY_MSG = "Nobody has negative balance";

	private static String[] negativeBalance( String[][] balances ) {
		Map<String, Integer> lenderBalance = new HashMap<>();
		Map<String, Integer> borrowerBalance = new HashMap<>();
		String borrower = null;
		String lender = null;
		int amount = 0;
		for ( int row = 0; row < balances.length; row++ ) {
			for ( int column = 0; column < balances[ row ].length; column++ ) {
				switch ( column ) {
					case 0:
						borrower = balances[ row ][ column ];
						break;
					case 1:
						lender = balances[ row ][ column ];
						break;
					case 2:
						amount = Integer.valueOf( balances[ row ][ column ] );
						break;
				}
			}
			if ( !lenderBalance.containsKey( lender ) ) {
				lenderBalance.put( lender, amount );
			} else {
				lenderBalance.put( lender, lenderBalance.get( lender ) + amount );
			}
			if ( !borrowerBalance.containsKey( borrower ) ) {
				borrowerBalance.put( borrower, amount );
			} else {
				borrowerBalance.put( borrower, borrowerBalance.get( borrower ) + amount );
			}
		}

		Map<String, Integer> resultPairs = new HashMap<>();
		borrowerBalance.forEach( ( borrowerKey, borrowerValue ) -> {
			if ( lenderBalance.containsKey( borrowerKey ) ) {
				resultPairs.put( borrowerKey, (lenderBalance.get( borrowerKey ) - borrowerBalance.get( borrowerKey )) );
			} else {
				resultPairs.put( borrowerKey, Math.negateExact( borrowerValue ) );
			}
		} );

		boolean hasNegativeBalance = false;
		for ( String resultKey : resultPairs.keySet() ) {
			if ( resultPairs.get( resultKey ) < 0 ) {
				hasNegativeBalance = true;
			}
		}
		if ( !hasNegativeBalance ) {
			return new String[]{ NOBODY_MSG };
		}

		Map<String, Integer> reverseOrderResultMap = new LinkedHashMap<>();
		resultPairs.entrySet().stream()
				.sorted( Map.Entry.comparingByValue() )
				.forEachOrdered( entry -> reverseOrderResultMap.put( entry.getKey(), entry.getValue() ) );
		Map<Integer, Long> countResultValues = reverseOrderResultMap.values().stream()
				.collect( Collectors.groupingBy( Function.identity(), Collectors.counting() ) );
		long countDuplicates = 0L;
		for ( Map.Entry<String, Integer> entry : reverseOrderResultMap.entrySet() ) {
			if ( countResultValues.get( entry.getValue() ) > 1 ) {
				countDuplicates = countResultValues.get( entry.getValue() );
			}
		}
		Iterator<String> resultMapIterator = reverseOrderResultMap.keySet().iterator();
		List<String> resultNames = new ArrayList<>();
		if ( countDuplicates == 0L ) {
			resultNames.add( resultMapIterator.next() );
			return resultNames.toArray( new String[ resultNames.size() ] );
		}
		for ( int i = 0; i < countDuplicates; i++ ) {
			resultNames.add( resultMapIterator.next() );
		}
		return resultNames.toArray( new String[ resultNames.size() ] );
	}

	public static void main( String[] args ) {
//		Scanner scanner = new Scanner( System.in );
//		int numberOfTransactions = scanner.nextInt();
//		int numberOfColumns = scanner.nextInt();
//		String[][] debts = new String[ numberOfTransactions ][ numberOfColumns ];
//		for ( int row = 0; row < numberOfTransactions; row++ ) {
//			for ( int column = 0; column < numberOfColumns; column++ ) {
//				debts[ row ][ column ] = scanner.next();
//			}
//		}
//		String[][] debts = new String[][]{
//				{ "Alex", "Blake", "5" },
//				{ "Blake", "Alex", "3" },
//				{ "Casey", "Alex", "7" },
//				{ "Casey", "Alex", "4" },
//				{ "Casey", "Alex", "2" } };
		String[][] debts = new String[][]{
				{ "Alex", "Blake", "2" },
				{ "Blake", "Alex", "2" },
				{ "Casey", "Alex", "5" },
				{ "Blake", "Casey", "7" },
				{ "Alex", "Blake", "4" },
				{ "Alex", "Casey", "4" } };
		System.out.println( Arrays.toString( negativeBalance( debts ) ) );
	}

}
