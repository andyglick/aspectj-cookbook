package com.oreilly.aspectjcookbook;

public class SimpleTextPhraseBuilder implements TextPhraseBuilder
{
	public void buildHeader(String title)
	{
		this.result.append("Title: ");
		this.result.append(title);
		this.result.append('\n');
	}

	public void buildBody(String content)
	{
		this.result.append("Content: ");
		this.result.append(content);
		this.result.append('\n');
	}

	public void buildFooter(String closingContent)
	{
		this.result.append("Footer: ");
		this.result.append(closingContent);
		this.result.append('\n');
	}
}
