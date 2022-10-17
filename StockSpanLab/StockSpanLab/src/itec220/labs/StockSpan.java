package itec220.labs;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class StockSpan {
	
	private ArrayList<Double> prices = new ArrayList<Double>();
	private ArrayList<LocalDate> dates  = new ArrayList<LocalDate>();
	private ArrayList<Integer> spans  = new ArrayList<Integer>();
	private boolean updateSpansNeeded = false;
	public StockSpan() {
		super();
		
	}

	
	public int numberofDays()
	{
		return prices.size();
	}
	
	/*
	 * Fill the spans arrayList with the span for the day or the same index in prices.
	 * Use Brute Force.
	 */
	private void calculateSpansBruteForce()
	{
		spans.add(1);
		
		for(int i = 1; i < prices.size(); i++) {
			int span = 1;
			int j = i - 1;
			
			while(j >= 0 && prices.get(i) >= prices.get(j)) {
				span++;
				j--;
			}
			
			spans.add(span);
		}
	}
	/*
	 * Fill the spans arrayList with the span for the day or the same index in prices.
	 * Use better algorithm.
	 */
	private void calculateSpans()
	{
		StackA<Integer> stack = new StackA<Integer>();
		stack.push(1);
		spans.add(1);
		
		for(int i = 1; i < prices.size(); i++) {
			if(prices.get(i) < prices.get(i - 1)) {
				spans.add(1);
				stack.push(1);
			}
			else {
				int span = 1;
				int prev = i - 1;
				
				while(prev >= 0 && (prices.get(i) >= prices.get(prev))) {
					int prevSpan = stack.pop();
					span += prevSpan;
					prev -= prevSpan;
				}
				
				if(prev < 0) {
					prev = 0;
				}
				
				spans.add(span);
				stack.push(span);
			}
		}
	}
	
	public void addPrice(double price, LocalDate date)
	{
		updateSpansNeeded = true;
		dates.add(date);
		prices.add(price);
		
	}
	 

	public void print()
	{
		if(updateSpansNeeded)
		{
			//calculateSpansBruteForce();
			updateSpansNeeded = false;
			calculateSpans(); //<< use this eventually
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
		for (int i = 0; i < spans.size(); i++)
		{
			System.out.println(String.format("%s spans %d days",this.getDate(i).format(formatter) , this.getSpan(i)));
			
		}
		System.out.println();
	}
	
	public int getSpan(int day)
	{
		if(day >= prices.size())
		{
			throw new IndexOutOfBoundsException();
		}
		if(updateSpansNeeded)
		{
			//calculateSpansBruteForce();
			calculateSpans();
			updateSpansNeeded = false;
		}
		
		return spans.get(day);
	}
	public LocalDate getDate(int day)
	{   		
		
		if(day >= dates.size())
		{
			 throw new IndexOutOfBoundsException();
		}
		return dates.get(day);
	}
}
