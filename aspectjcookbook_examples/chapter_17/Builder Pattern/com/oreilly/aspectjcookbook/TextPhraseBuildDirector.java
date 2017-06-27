package com.oreilly.aspectjcookbook;

public class TextPhraseBuildDirector
{
	private TextPhraseBuilder builder;
	private String phraseTitle = "Quotes";
	private String phraseContent = "To be or not to be, that is the question";
	private String phraseFooter = "William Shaespeare, professional bard";
	
	public TextPhraseBuildDirector(TextPhraseBuilder builder)
	{
		this.builder = builder;
	}
	
	public void construct()
	{
		builder.buildHeader(this.phraseTitle);
		builder.buildBody(this.phraseContent);
		builder.buildFooter(this.phraseFooter);
	}
}
