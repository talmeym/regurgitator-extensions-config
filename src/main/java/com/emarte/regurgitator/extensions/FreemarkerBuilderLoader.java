/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;

import static com.emarte.regurgitator.core.FileUtil.getInputStreamForFile;
import static com.emarte.regurgitator.core.FileUtil.streamToString;

abstract class FreemarkerBuilderLoader {
    ValueBuilder buildFreemarkerValueBuilder(String source, String value, String file, boolean allContexts, Log log) throws RegurgitatorException {
        int numberSet = 0;
        numberSet = source != null ? ++numberSet : numberSet;
        numberSet = value != null ? ++numberSet : numberSet;
        numberSet = file != null ? ++numberSet : numberSet;

        if(numberSet != 1) {
            throw new RegurgitatorException("One of source, value or file is required");
        }

        if(file != null) {
            try {
                value = streamToString(getInputStreamForFile(file));
            } catch (Exception e) {
                throw new RegurgitatorException("Error loading file: " + file, e);
            }
        }

        ContextLocation location = source != null ? new ContextLocation(source) : null;
        log.debug("Loaded freemarker builder");
        return new FreemarkerBuilder(new ValueSource(location, value), allContexts);
    }
}
