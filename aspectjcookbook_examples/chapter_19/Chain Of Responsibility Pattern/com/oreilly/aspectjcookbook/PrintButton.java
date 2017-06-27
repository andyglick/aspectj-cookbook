package com.oreilly.aspectjcookbook;

import java.util.Timer;
import java.util.TimerTask;

public class PrintButton
{
	Timer eventTimer = new Timer();
	
	public void startEvents()
	{
		// The timer allows us to effectively pretend than the user is
		// invoking this button at regular intervals
		eventTimer = new Timer();
		long delay = 1000;
		long period = 2000;
		eventTimer.schedule(new TimerTask()
			{
				public void run()
				{
					doClick(new String("Help Triggered from PrintButton"));
				}
			}, 
			delay, 
			period);
	}

	public void doClick(Object object)
	{
		// Potentially do more application specific logic here
	}
	
	public void stopEvents()
	{
		eventTimer.cancel();
	}
}
