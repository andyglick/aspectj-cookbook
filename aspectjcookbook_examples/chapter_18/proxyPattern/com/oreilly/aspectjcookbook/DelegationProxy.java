package com.oreilly.aspectjcookbook;

import com.oreilly.aspectjcookbook.oopatterns.ProxyPattern;
import org.aspectj.lang.JoinPoint;

public aspect DelegationProxy extends ProxyPattern 
{
	declare parents : RealSubject implements Subject;

	protected pointcut requestTriggered() : call(* RealSubject.write(..));

	protected boolean reject(
		Object caller,
		Subject subject,
		JoinPoint joinPoint)
	{

		return false;

	}

	protected boolean delegate(
		Object caller,
		Subject subject,
		JoinPoint joinPoint)
	{
		return true;
	}

	protected Object rejectRequest(
		Object caller,
		Subject subject,
		JoinPoint joinPoint)
	{
		return null;
	}

	protected Object delegateRequest(
		Object caller,
		Subject subject,
		JoinPoint joinPoint)
	{
		Object[] args = joinPoint.getArgs();
		if (args != null)
		{
			AnotherRealSubject.write((String) args[0]);
		}
		else
		{
			AnotherRealSubject.write("");
		}
		return null;
	}
}
