/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.extensions;

import uk.emarte.regurgitator.core.AbstractEntityPack;

import java.util.HashMap;

public class ExtensionsEntityPack extends AbstractEntityPack {
    public ExtensionsEntityPack() {
        addConditionBehaviour("contains-json-path", new ContainsJsonPathBehaviour());
        addConditionBehaviour("contains-xpath", new ContainsXpathBehaviour(new HashMap<>()));
        addConditionBehaviour("meets-xml-schema", new MeetsXmlSchemaBehaviour());
        addConditionBehaviour("meets-json-schema", new MeetsJsonSchemaBehaviour());
        addValueProcessor("json-print-processor", new JsonPrintProcessor());
    }
}
