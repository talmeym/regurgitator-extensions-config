/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;

import static com.emarte.regurgitator.core.FileUtil.getInputStreamForFile;
import static com.emarte.regurgitator.core.FileUtil.streamToString;

abstract class JsonParameterLoader {
    Step buildJsonParameter(String id, ParameterPrototype prototype, String context, String source, String value, String file, ValueProcessor processor, String jsonPath, Log log) throws RegurgitatorException {
        int numberSet = 0;
        numberSet = source != null ? ++numberSet : numberSet;
        numberSet = value != null ? ++numberSet : numberSet;
        numberSet = file != null ? ++numberSet : numberSet;

        if(numberSet == 0) {
            throw new RegurgitatorException("Source, value or file is required");
        }

        if(value != null && file != null) {
            throw new RegurgitatorException("Value and file not both allowed");
        }

        if(file != null) {
            try {
                value = streamToString(getInputStreamForFile(file));
            } catch (Exception e) {
                throw new RegurgitatorException("Error loading file: " + file, e);
            }
        }

        ContextLocation location = source != null ? new ContextLocation(source) : null;

        log.debug("Loaded json parameter '{}'", id);
        return new JsonParameter(id, prototype, context, new ValueSource(location, value), new JsonPathProcessor(jsonPath), processor);
    }
}
