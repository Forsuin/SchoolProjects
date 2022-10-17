package itec220.labs;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

class TestStockSpan {

	
	@Test
	void testStockSpanOneDay() {

		
		//Stock Span for one day
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
		LocalDate ld = LocalDate.parse("10/1/2021", formatter);
		//Stock Span for two days
		StockSpan stockspan = new StockSpan();
		stockspan.addPrice(100,ld);
		int expected = 1;
		int actual = stockspan.getSpan(0);
		assertEquals(expected,actual);
	}


	
	@Test
	void testStockSpanSecondDayLess() {

		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
		LocalDate ld = LocalDate.parse("10/01/2021", formatter);
		//Stock Span for two days
		StockSpan stockspan = new StockSpan();
		stockspan.addPrice(100,ld);
		stockspan.addPrice(80,ld.plusDays(1));
		int expected = 1;
		int actual = stockspan.getSpan(1);
		assertEquals(expected,actual);
	}

	@Test
	void testStockSpanSecondDayMore() {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
		LocalDate ld = LocalDate.parse("10/01/2021", formatter);
		//Stock Span for two days
		StockSpan stockspan = new StockSpan();
		stockspan.addPrice(80,ld);
		stockspan.addPrice(100,ld.plusDays(1));
		int expected = 2;
		int actual = stockspan.getSpan(1);
		assertEquals(expected,actual);
	}

	
	@Test
	void testStockSpanMany() {

		// Daily Stock Prices 100, 80, 60, 70, 60, 75, 85
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
		LocalDate ld = LocalDate.parse("10/01/2021", formatter);
		StockSpan stockspan = new StockSpan();
		stockspan.addPrice(100,ld);
		stockspan.addPrice(80,ld.plusDays(1));
		stockspan.addPrice(60,ld.plusDays(1));
		stockspan.addPrice(70,ld.plusDays(1));
		stockspan.addPrice(60,ld.plusDays(1));
		stockspan.addPrice(75,ld.plusDays(1));
		stockspan.addPrice(80,ld.plusDays(1));
		
		
		assertAll(() -> assertEquals(1,stockspan.getSpan(0)),
				() -> assertEquals(1,stockspan.getSpan(1)),
				() -> assertEquals(1,stockspan.getSpan(2)),
				() -> assertEquals(2,stockspan.getSpan(3)),
				() -> assertEquals(1,stockspan.getSpan(4)),
				() -> assertEquals(4,stockspan.getSpan(5)),
				() -> assertEquals(6,stockspan.getSpan(6))	);
	}
}
