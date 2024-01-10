/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.extensions;

import uk.emarte.regurgitator.core.Log;
import uk.emarte.regurgitator.core.RegurgitatorException;
import uk.emarte.regurgitator.core.ValueProcessor;

import static uk.emarte.regurgitator.core.ValueSourceLoader.loadValueSourceForProcessor;

abstract class FreemarkerProcessorLoader {
    ValueProcessor buildFreemarkerValueProcessor(String value, String file, Log log) throws RegurgitatorException {
        log.debug("Loaded freemarker processor");
        return new FreemarkerProcessor(loadValueSourceForProcessor(value, file));
    }
}
