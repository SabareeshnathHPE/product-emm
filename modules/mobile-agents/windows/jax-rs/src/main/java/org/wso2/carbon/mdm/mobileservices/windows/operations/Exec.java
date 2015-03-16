/*
 *  Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * /
 */

package org.wso2.carbon.mdm.mobileservices.windows.operations;

import org.wso2.carbon.mdm.mobileservices.windows.operations.util.Constants;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Commands that needs to be executed on the device.
 */
public class Exec {
	int commandId = 0;
	Item[] items;

	public int getCommandId() {
		return commandId;
	}

	public void setCommandId(int commandId) {
		this.commandId = commandId;
	}

	public Item[] getItems() {
		return items;
	}

	public void setItems(Item[] items) {
		this.items = items;
	}

	public void buildExecElement(Document doc, Element rootElement) {
		if (getItems() != null) {
			Element get = doc.createElement(Constants.EXECUTE);
			rootElement.appendChild(get);
			if (getCommandId() != 0) {
				Element commandId = doc.createElement(Constants.COMMAND_ID);
				commandId.appendChild(doc.createTextNode(String.valueOf(getCommandId())));
				get.appendChild(commandId);
			}
			for (int x = 0; x < getItems().length; x++) {
				if (getItems()[x] != null) {
					getItems()[x].buildItemElement(doc, get);
				}
			}
		}
	}

}
