/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;

import java.io.IOException;

import static com.emarte.regurgitator.core.FileUtil.getInputStreamForFile;
import static com.emarte.regurgitator.core.FileUtil.streamToString;

abstract class FreemarkerProcessorLoader {
    ValueProcessor buildFreemarkerValueProcessor(String value, String file, Log log) throws RegurgitatorException {
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

        log.debug("Loaded freemarker processor");
        return new FreemarkerProcessor(value);
    }
}
