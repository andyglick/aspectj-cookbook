package com.oreilly.aspectjcookbook.oopatterns;

import org.aspectj.lang.JoinPoint;

public abstract aspect ProxyPattern 
{

	protected interface Subject
	{
	}

	protected abstract pointcut requestTriggered();

	private pointcut accessByCaller(Object caller) : requestTriggered() && this(caller);
	
	private pointcut accessByUnknown() : requestTriggered() && !accessByCaller(Object);

	Object around(Object caller, Subject subject) : accessByCaller(caller)
		&& target(subject)
	{
		if (reject(caller, subject, thisJoinPoint))
		{
			return rejectRequest(caller, subject, thisJoinPoint);
		}
		else if (delegate(caller, subject, thisJoinPoint))
		{
			return delegateRequest(caller, subject, thisJoinPoint);
		}

		return proceed(caller, subject);
	}
	
	Object around(Subject subject) : accessByUnknown()
	&& target(subject)
	{
	   // Without a caller then reject does not really make sense
	   // as there is no way of deciding to reject or not
	   if (delegate(null, subject, thisJoinPoint))
		{
			return delegateRequest(null, subject, thisJoinPoint);
		}

		return proceed(subject);
	}

	protected abstract boolean reject(
		Object caller,
		Subject subject,
		JoinPoint joinPoint);

	protected abstract boolean delegate(
		Object caller,
		Subject subject,
		JoinPoint joinPoint);

	protected abstract Object rejectRequest(
		Object caller,
		Subject subject,
		JoinPoint joinPoint);

	protected abstract Object delegateRequest(
		Object caller,
		Subject subject,
		JoinPoint joinPoint);
}
