package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.AbstractEntityPack;

public class ExtensionsEntityPack extends AbstractEntityPack {
	public ExtensionsEntityPack() {
		addConditionBehaviour("contains-json-path", new ContainsJsonPathBehaviour());
	}
}
