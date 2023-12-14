/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.Log;
import com.emarte.regurgitator.core.RegurgitatorException;
import com.emarte.regurgitator.core.ValueBuilder;

import static com.emarte.regurgitator.core.ValueSourceLoader.loadValueSource;

abstract class VelocityBuilderLoader {
    ValueBuilder buildVelocityValueBuilder(String source, String value, String file, boolean allContexts, Log log) throws RegurgitatorException {
        log.debug("Loaded velocity builder");
        return new VelocityBuilder(loadValueSource(source, value, file), allContexts);
    }
}
