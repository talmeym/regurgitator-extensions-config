package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.AbstractEntityPack;

import java.util.HashMap;

public class ExtensionsEntityPack extends AbstractEntityPack {
	public ExtensionsEntityPack() {
		addConditionBehaviour("contains-json-path", new ContainsJsonPathBehaviour());
		addConditionBehaviour("contains-xpath", new ContainsXpath(new HashMap<String, String>()));
	}
}
