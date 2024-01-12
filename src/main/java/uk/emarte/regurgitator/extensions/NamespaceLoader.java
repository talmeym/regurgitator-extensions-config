/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.extensions;

import uk.emarte.regurgitator.core.Log;

import java.util.HashMap;
import java.util.Map;

class NamespaceLoader {
    static Map<String, String> loadNamespaces(String string, Log log) {
        Map<String, String> namespaceMap = new HashMap<>();

        if(string != null) {
            for(String part: string.split(",")) {
                String prefix = part.substring(0, part.indexOf("="));
                String uri = part.substring(part.indexOf("=") + 1);
                namespaceMap.put(prefix, uri);
                log.debug("Loaded namespace '{}={}'", prefix, uri);
            }
        }

        log.debug("Loaded {} namespaces", namespaceMap.size());
        return namespaceMap;
    }
}
