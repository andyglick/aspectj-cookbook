package com.oreilly.aspectjcookbook;

public class MainApplication
{
	public static void main(String[] args)
	{
		EntryField currentSelectionEntryField = new EntryField();
		ListBox listBox = new ListBox();

		DialogMediator.aspectOf().setMediator(
			listBox,
			currentSelectionEntryField);

		System.out.println(
			"Set the list box's first selection to 'First Selection'");

		listBox.setSelection("First Selection");

		System.out.println(
			"Current Selection Entry Field shows: "
				+ currentSelectionEntryField.getText());
	}
}
