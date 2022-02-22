package com.morganstanley.rolingstrings2;

public class RotateRightCommand implements RotateCommand {

	private InputText inputText;

	public RotateRightCommand( InputText inputText ) {
		this.inputText = inputText;
	}

	@Override
	public char[] execute() {
		return inputText.rotateRight();
	}

}
