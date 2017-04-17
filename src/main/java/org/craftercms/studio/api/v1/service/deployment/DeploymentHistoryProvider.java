/*
 * Crafter Studio Web-content authoring solution
 * Copyright (C) 2007-2017 Crafter Software Corporation.
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

package org.craftercms.studio.api.v1.service.deployment;

import org.craftercms.studio.api.v1.dal.DeploymentSyncHistory;

import java.util.Date;
import java.util.List;

public interface DeploymentHistoryProvider {

    /**
     * Get deployment history for given site
     *
     * @param site site id
     * @param fromDate date from
     * @param toDate date to
     * @param filterType filter items by type
     * @param numberOfItems number of items in result set
     * @return
     */
    List<DeploymentSyncHistory> getDeploymentHistory(String site, Date fromDate, Date toDate, String filterType, int numberOfItems);

    /**
     * Get last deployment date time for given site and path
     *
     * @param site site id
     * @param path path
     * @return last deployment date or null if never deployed
     */
    Date getLastDeploymentDate(String site, String path);
}