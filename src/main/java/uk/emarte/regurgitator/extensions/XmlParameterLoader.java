/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.extensions;

import uk.emarte.regurgitator.core.*;

import java.util.List;

import static uk.emarte.regurgitator.core.ValueSourceLoader.loadValueSource;

abstract class XmlParameterLoader {
    Step buildXmlParameter(String id, ParameterPrototype prototype, String context, String source, String value, String file, List<ValueProcessor> processors, XpathProcessor xpathProcessor, boolean optional, Log log) throws RegurgitatorException {
        log.debug("Loaded xml parameter '{}'", id);
        return new XmlParameter(id, prototype, context, loadValueSource(source, value, file), xpathProcessor, processors, optional);
    }
}
