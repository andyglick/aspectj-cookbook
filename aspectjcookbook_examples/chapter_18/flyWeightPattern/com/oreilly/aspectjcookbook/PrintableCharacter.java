package com.oreilly.aspectjcookbook;

public class PrintableCharacter
{
	private char character;
	
  public PrintableCharacter(Character character)
  {
    this.character = character.charValue();
  }

  public void print(boolean uppercase)
  {
    System.out.print(uppercase ? Character.toUpperCase(character) : character);
  }
}
