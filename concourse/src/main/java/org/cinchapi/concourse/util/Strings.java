/*
 * The MIT License (MIT)
 * 
 * Copyright (c) 2013-2015 Jeff Nelson, Cinchapi Software Collective
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.cinchapi.concourse.util;

/**
 * Yet another utility class for {@link String} objects.
 * 
 * @author jnelson
 */
public final class Strings {

    /**
     * The default delimiter on which to split strings
     */
    private static final String DEFAULT_DELIMITER = ",";

    /**
     * Split a string on a delimiter as long as that delimiter is not wrapped in
     * quotes.
     * 
     * @param string
     * @param delimiter
     * @return the split string tokens
     */
    public static String[] splitStringByDelimterAndRespectQuotes(String string,
            String delimiter) {
        // http://stackoverflow.com/a/15739087/1336833
        // TODO CON-211 this needs to support single quotes
        return string.split(delimiter + "(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
    }

    /**
     * Split a string on a "comma" delimiter as long as the comma is not wrapped
     * in quotes.
     * 
     * @param string
     * @return the split string tokens
     */
    public static String[] splitStringByDelimterAndRespectQuotes(String string) {
        return splitStringByDelimterAndRespectQuotes(string, DEFAULT_DELIMITER);
    }

    private Strings() {/* noop */}

}
