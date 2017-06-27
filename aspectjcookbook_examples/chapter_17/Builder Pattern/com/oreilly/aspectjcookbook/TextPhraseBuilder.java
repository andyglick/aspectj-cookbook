package com.oreilly.aspectjcookbook;

public interface TextPhraseBuilder
{
	public void buildHeader(String title);
	
	public void buildBody(String content);
	
	public void buildFooter(String closingContent);
	
	public String getResult();
}
