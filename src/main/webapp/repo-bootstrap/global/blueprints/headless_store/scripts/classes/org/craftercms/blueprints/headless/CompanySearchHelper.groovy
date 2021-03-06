/*
 * Copyright (C) 2007-2019 Crafter Software Corporation. All Rights Reserved.
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

package org.craftercms.blueprints.headless

import groovy.util.logging.Slf4j

@Slf4j
class CompanySearchHelper extends SearchHelper {
	
	def CompanySearchHelper(searchService, siteItemService) {
		super(searchService, siteItemService)
		filter("content-type:\"/component/company\"")
		sortBy("name_s asc")
	}
	
	def processItem(doc) {
		def item = super.processItem(doc)
		[
			id: item.objectId.text,
			name: item.name_s,
			logo: item.logo_s,
			website: item.website_s,
			email: item.email_s,
			phone: item.phone_s,
			description: item.description_html,
            itemUrl: doc.localId
		]
	}
	
}