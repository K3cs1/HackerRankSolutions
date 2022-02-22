package com.morganstanley.rolingstrings2;

public class RotateLeftCommand implements RotateCommand {

	private InputText inputText;

	public RotateLeftCommand( InputText inputText ) {
		this.inputText = inputText;
	}

	@Override
	public char[] execute() {
		return inputText.rotateLeft();
	}
}
