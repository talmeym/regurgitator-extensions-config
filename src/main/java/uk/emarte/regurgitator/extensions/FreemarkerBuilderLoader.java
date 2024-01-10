/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.extensions;

import uk.emarte.regurgitator.core.Log;
import uk.emarte.regurgitator.core.RegurgitatorException;
import uk.emarte.regurgitator.core.ValueBuilder;

import static uk.emarte.regurgitator.core.ValueSourceLoader.loadValueSource;

abstract class FreemarkerBuilderLoader {
    ValueBuilder buildFreemarkerValueBuilder(String source, String value, String file, boolean allContexts, Log log) throws RegurgitatorException {
        log.debug("Loaded freemarker builder");
        return new FreemarkerBuilder(loadValueSource(source, value, file), allContexts);
    }
}
