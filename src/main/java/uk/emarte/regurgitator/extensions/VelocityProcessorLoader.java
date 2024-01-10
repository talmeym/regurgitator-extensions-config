/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.extensions;

import uk.emarte.regurgitator.core.Log;
import uk.emarte.regurgitator.core.RegurgitatorException;
import uk.emarte.regurgitator.core.ValueProcessor;

import java.io.IOException;

import static uk.emarte.regurgitator.core.FileUtil.getInputStreamForFile;
import static uk.emarte.regurgitator.core.FileUtil.streamToString;

abstract class VelocityProcessorLoader {
    ValueProcessor buildVelocityValueProcessor(String value, String file, Log log) throws RegurgitatorException {
        int numberSet = 0;
        numberSet = value != null ? ++numberSet : numberSet;
        numberSet = file != null ? ++numberSet : numberSet;

        if(numberSet != 1) {
            throw new RegurgitatorException("One of value or file is required");
        }

        if(file != null) {
            try {
                value = streamToString(getInputStreamForFile(file));
            } catch (IOException e) {
                throw new RegurgitatorException("Error loading file: " + file, e);
            }
        }

        log.debug("Loaded velocity processor");
        return new VelocityProcessor(value);
    }
}
