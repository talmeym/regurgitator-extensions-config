/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;

import java.util.List;

import static com.emarte.regurgitator.core.ValueSourceLoader.loadValueSource;

abstract class JsonParameterLoader {
    Step buildJsonParameter(String id, ParameterPrototype prototype, String context, String source, String value, String file, List<ValueProcessor> processors, String jsonPath, Log log) throws RegurgitatorException {
        log.debug("Loaded json parameter '{}'", id);
        return new JsonParameter(id, prototype, context, loadValueSource(source, value, file), new JsonPathProcessor(jsonPath), processors);
    }
}
