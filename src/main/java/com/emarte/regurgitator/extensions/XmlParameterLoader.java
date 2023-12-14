/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;

import java.util.List;

import static com.emarte.regurgitator.core.ValueSourceLoader.loadValueSource;

abstract class XmlParameterLoader {
    Step buildXmlParameter(String id, ParameterPrototype prototype, String context, String source, String value, String file, List<ValueProcessor> processors, XpathProcessor xpathProcessor, Log log) throws RegurgitatorException {
        log.debug("Loaded xml parameter '{}'", id);
        return new XmlParameter(id, prototype, context, loadValueSource(source, value, file), xpathProcessor, processors);
    }
}
