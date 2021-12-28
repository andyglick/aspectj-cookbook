package com.oreilly.aspectjcookbook;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;

public class TimedEvent extends TimerTask
{
	private Date startDate;

	public TimedEvent(long timeout)
	{
		Timer timer = new Timer();
		this.startDate = new Date();
		timer.schedule(this, timeout);
	}

	public void run()
	{
		this.timedOut();
	}
	public void timedOut()
	{
	}
}