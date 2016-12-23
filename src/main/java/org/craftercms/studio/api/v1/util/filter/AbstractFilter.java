/*
 * Crafter Studio Web-content authoring solution
 * Copyright (C) 2007-2016 Crafter Software Corporation.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.craftercms.studio.api.v1.util.filter;

import org.craftercms.studio.api.v1.util.StudioConfiguration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract public class AbstractFilter implements Filter {

    protected StudioConfiguration studioConfiguration;

    public abstract String getIncludePattern();

    public StudioConfiguration getStudioConfiguration() { return studioConfiguration; }
    public void setStudioConfiguration(StudioConfiguration studioConfiguration) { this.studioConfiguration = studioConfiguration; }

    public boolean match(String contentType) {
        if(contentType != null) {
            String includePattern = getIncludePattern();
            Pattern pattern = Pattern.compile(includePattern);
            Matcher matcher = pattern.matcher(contentType);
            return matcher.matches();
        }
        return false;
    }
}
