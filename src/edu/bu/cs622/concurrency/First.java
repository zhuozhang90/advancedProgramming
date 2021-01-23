package edu.bu.cs622.concurrency;

class First implements Runnable { 
	private int i; 
	private Counter ctr; 
	public First(int i, Counter c) { 
		this.i = i; this.ctr = c; 
	} 
	
	public void changeCounter(Counter cntr) { 
		if (i > 0) { 
			synchronized(cntr) {
				cntr.increment();
			} 
		} 
	} 
	
	public void run() { changeCounter(ctr); } 
	
}
