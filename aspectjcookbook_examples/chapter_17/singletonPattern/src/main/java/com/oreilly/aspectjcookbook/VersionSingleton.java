package com.oreilly.aspectjcookbook;

import com.oreilly.aspectjcookbook.oopatterns.SingletonPattern;

public aspect VersionSingleton extends SingletonPattern 
{	
	declare parents: Version implements Singleton;	
}
