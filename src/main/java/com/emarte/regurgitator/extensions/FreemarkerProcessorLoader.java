package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;

public abstract class FreemarkerProcessorLoader {
	protected ValueProcessor buildFreemarkerValueProcessor(String value, String file, Log log) throws RegurgitatorException {
		int numberSet = 0;
		numberSet = value != null ? ++numberSet : numberSet;
		numberSet = file != null ? ++numberSet : numberSet;

		if(numberSet != 1) {
			throw new RegurgitatorException("One of value or file is required");
		}

		if(file != null) {
			try {
				value = FileUtil.streamToString(FileUtil.getInputStreamForFile(file));
			} catch (Exception e) {
				throw new RegurgitatorException("Error loading file: " + file, e);
			}
		}

		log.debug("Loaded freemarker processor");
		return new FreemarkerProcessor(value);
	}
}
