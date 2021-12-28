package com.oreilly.aspectjcookbook;

import com.oreilly.aspectjcookbook.oopatterns.ProxyPattern;
import org.aspectj.lang.JoinPoint;

public aspect ProtectionProxy extends ProxyPattern 
{
	declare parents : RealSubject implements Subject;

	protected pointcut requestTriggered() : call(* RealSubject.print(..));

	protected boolean reject(
		Object caller,
		Subject subject,
		JoinPoint joinPoint)
	{
		if (joinPoint.getThis() instanceof MainApplication)
		{
			System.out.println(
				"[MyRejecting:] Intercepting calls to "
					+ "RealSubject.print() from Main");
			return true;
		}
		else
		{
			return false;
		}
	}

	protected boolean delegate(
		Object caller,
		Subject subject,
		JoinPoint joinPoint)
	{
		return false;
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
		return null;
	}
}
