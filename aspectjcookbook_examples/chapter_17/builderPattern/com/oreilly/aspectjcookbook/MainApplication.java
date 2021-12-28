package com.oreilly.aspectjcookbook;

public class MainApplication
{
	public static void main(String[] args)
	{
		TextPhraseBuildDirector director;

		System.out.println("Building a simple text output\n");

		TextPhraseBuilder simpleBuilder = new SimpleTextPhraseBuilder();

		director = new TextPhraseBuildDirector(simpleBuilder);

		director.construct();

		System.out.println(simpleBuilder.getResult());

		System.out.println("Building an html text output\n");

		TextPhraseBuilder htmlBuilder = new HTMLTextPhraseBuilder();

		director = new TextPhraseBuildDirector(htmlBuilder);

		director.construct();

		System.out.println(htmlBuilder.getResult());

	}
}
