package com.oreilly.aspectjcookbook;

public class HTMLTextPhraseBuilder implements TextPhraseBuilder
{
	public void buildHeader(String title)
	{
		this.result.append("<html>\n\t<head>\n\t\t<title>");
		this.result.append(title);
		this.result.append("</title>\n\t</head>\n");
	}

	public void buildBody(String content)
	{
		this.result.append("\t<body>\n");
		this.result.append("\t\t<p>\n");
		this.result.append(content);
		this.result.append('\n');
		this.result.append("\t\t</p>\n");
	}

	public void buildFooter(String closingContent)
	{
		this.result.append("\t\t<p>\n");
		this.result.append(closingContent);
		this.result.append('\n');
		this.result.append("\t\t</p>\n");
		this.result.append("\t</body>\n");
		this.result.append("</html>");
		this.result.append('\n');
	}
}
