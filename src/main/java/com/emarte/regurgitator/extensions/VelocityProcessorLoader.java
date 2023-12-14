/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.Log;
import com.emarte.regurgitator.core.RegurgitatorException;
import com.emarte.regurgitator.core.ValueProcessor;

import static com.emarte.regurgitator.core.ValueSourceLoader.loadValueSourceForProcessor;

abstract class VelocityProcessorLoader {
    ValueProcessor buildVelocityValueProcessor(String value, String file, Log log) throws RegurgitatorException {
        log.debug("Loaded velocity processor");
        return new VelocityProcessor(loadValueSourceForProcessor(value, file));
    }
}
