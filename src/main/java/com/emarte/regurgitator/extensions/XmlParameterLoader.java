package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;

public abstract class XmlParameterLoader {
	protected Step buildXmlParameter(String id, ParameterPrototype prototype, String context, String source, String value, String file, ValueProcessor processor, XpathProcessor xpathProcessor, Log log) throws RegurgitatorException {
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
				value = FileUtil.streamToString(FileUtil.getInputStreamForFile(file));
			} catch (Exception e) {
				throw new RegurgitatorException("Error loading file: " + file, e);
			}
		}

		ContextLocation location = source != null ? new ContextLocation(source) : null;

		log.debug("Loaded xml parameter '" + id + "'");
		return new XmlParameter(id, prototype, context, new ValueSource(location, value), xpathProcessor, processor);
	}
}
