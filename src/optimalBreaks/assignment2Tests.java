package optimalBreaks;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class assignment2Tests {
	
	@Test
	public void testEmptybreakList() {
		BreakSchedule x= new BreakSchedule();
		String w= "Holiday";
		ArrayList<Integer> b= null;
		assertEquals(0, x.totalCost(w,b));
	}
	
	@Test
	public void testEmptyString() {
		BreakSchedule x= new BreakSchedule();
		String w= "";
		ArrayList<Integer> b= new ArrayList<Integer>();
		b.add(3);
		assertEquals(0, x.totalCost(w,b));
	}
	
	@Test
	public void testEasybreakList() {
		BreakSchedule x= new BreakSchedule();
		String w= "Holiday";
		ArrayList<Integer> b= new ArrayList<Integer>();
		b.add(3);
		assertEquals(7, x.totalCost(w,b));
	}
	
	@Test
	public void testEasy2breakList() {
		BreakSchedule x= new BreakSchedule();
		String w= "Holiday";
		ArrayList<Integer> b= new ArrayList<Integer>();
		b.add(6);
		assertEquals(0, x.totalCost(w,b));
	}
	
	@Test
	public void testEasy3breakList() {
		BreakSchedule x= new BreakSchedule();
		String w= "Holiday";
		ArrayList<Integer> b= new ArrayList<Integer>();
		b.add(0);
		b.add(1);
		b.add(2);
		assertEquals(12, x.totalCost(w,b));
	}
	
	@Test
	public void testEasy4breakList() {
		BreakSchedule x= new BreakSchedule();
		String w= "Holiday";
		ArrayList<Integer> b= new ArrayList<Integer>();
		b.add(4);
		b.add(6);
		assertEquals(7, x.totalCost(w,b));
	}
	
	@Test
	public void testEmptybreakSchedule() {
		BreakSchedule x= new BreakSchedule();
		String w= "Holiday";
		ArrayList<Integer> b= null;
		assertEquals(null, x.breakSchedule(w,b));
	}
	
	@Test
	public void testEmptybreakScheduleEasy() {
		BreakSchedule x= new BreakSchedule();
		String w= "Holiday";
		ArrayList<Integer> b= new ArrayList<Integer>();
		b.add(3);
		ArrayList<Integer> schedule= x.breakSchedule(w,b);
		ArrayList<Integer> answer = new ArrayList<Integer>(); 
		answer.add(3);
		for(int i=0; i< schedule.size(); i++){
		 assertEquals(answer.get(i), schedule.get(i));
		}
	}
	
	@Test
	public void testEasy3breakSchedule() {
		BreakSchedule x= new BreakSchedule();
		String w= "Holiday";
		ArrayList<Integer> b= new ArrayList<Integer>();
		b.add(0);
		b.add(3);
		ArrayList<Integer> schedule= x.breakSchedule(w,b);
		ArrayList<Integer> answer = new ArrayList<Integer>(); 
		answer.add(3);
		answer.add(0);
		for(int i=0; i< schedule.size(); i++){
		 assertEquals(answer.get(i), schedule.get(i));
		}
	}
	
	@Test
	public void testEasy4breakSchedule() {
		BreakSchedule x= new BreakSchedule();
		String w= "Holiday";
		ArrayList<Integer> b= new ArrayList<Integer>();
		b.add(0);
		b.add(1);
		b.add(3);
		ArrayList<Integer> schedule= x.breakSchedule(w,b);
		ArrayList<Integer> answer = new ArrayList<Integer>(); 
		answer.add(3);
		answer.add(1);
		answer.add(0);
		for(int i=0; i< schedule.size(); i++){
		 assertEquals(answer.get(i), schedule.get(i));
		}
	}
	
	@Test
	public void testEasy5breakSchedule() {
		BreakSchedule x= new BreakSchedule();
		String w= "Holiday";
		ArrayList<Integer> b= new ArrayList<Integer>();
		b.add(6);
		ArrayList<Integer> schedule= x.breakSchedule(w,b);
		assertEquals(null, schedule);		
	}


	// CUSTOM TESTS

	// shouldn't this be 40??
	@Test
	public void customTest1() {
		BreakSchedule x= new BreakSchedule();
		String w= "abcdefghijklmnopqrst";
		ArrayList<Integer> b= new ArrayList<Integer>();
		b.add(3);
		b.add(8);
		b.add(10);
		assertEquals(38, x.totalCost(w,b));
	}

	@Test
	public void customTest2() {
		BreakSchedule x= new BreakSchedule();
		String w= "Holiday";
		ArrayList<Integer> b= new ArrayList<Integer>();
		b.add(0);
		b.add(1);
		b.add(2);
		ArrayList<Integer> schedule= x.breakSchedule(w,b);
		ArrayList<Integer> answer = new ArrayList<Integer>(); 
		answer.add(2);
		answer.add(1);
		answer.add(0);
		for(int i=0; i< schedule.size(); i++){
		 assertEquals(answer.get(i), schedule.get(i));
		}
		
	}


	@Test
	public void customTest3() {
		BreakSchedule x= new BreakSchedule();
		String w= "envelope";
		ArrayList<Integer> b= new ArrayList<Integer>();
		b.add(1);
		b.add(3);
		assertEquals(12, x.totalCost(w,b));
	}


	@Test
	public void customTest4() {
		BreakSchedule x= new BreakSchedule();
		String w= "abcdefghijklmnopqrst";
		ArrayList<Integer> b= new ArrayList<Integer>();
		b.add(3);
		b.add(8);
		b.add(10);
		ArrayList<Integer> schedule= x.breakSchedule(w,b);
		ArrayList<Integer> answer = new ArrayList<Integer>(); 
		answer.add(10);
		answer.add(3);
		answer.add(8);
		for(int i=0; i< schedule.size(); i++){
		 	assertEquals(answer.get(i), schedule.get(i));
		}		
	}


	@Test
	public void customTest5() {
		BreakSchedule x= new BreakSchedule();
		String w= "abcdefghijklmnopqrst";
		ArrayList<Integer> b= new ArrayList<Integer>();
		b.add(3);
		b.add(8);
		b.add(10);
		assertEquals(38, x.totalCost(w,b));
		
	}


	@Test
	public void customTest6() {
		BreakSchedule x= new BreakSchedule();
		String w= "abcdefghijk";
		ArrayList<Integer> b= new ArrayList<Integer>();
		b.add(3);
		b.add(8);
		assertEquals(18, x.totalCost(w,b));
		
	}


	

}
