package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.Log;

import java.util.*;

public class NamespaceLoader {
	public static Map<String, String> loadNamespaces(String attribute, Log log) {
		Map<String, String> namespaceMap = new HashMap<String,  String>();
		String[] parts = attribute.split(",");

		for(String part: parts) {
			String prefix = part.substring(0, part.indexOf("="));
			String uri = part.substring(part.indexOf("=") + 1);
			namespaceMap.put(prefix, uri);
			log.debug("Loaded namespace '" + prefix + "=" + uri + "'");
		}

		log.debug("Loaded " + namespaceMap.size() + " namespaces");
		return namespaceMap;
	}
}
