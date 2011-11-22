/**
* BigBlueButton open source conferencing system - http://www.bigbluebutton.org/
*
* Copyright (c) 2010 BigBlueButton Inc. and by respective authors (see below).
*
* This program is free software; you can redistribute it and/or modify it under the
* terms of the GNU Lesser General Public License as published by the Free Software
* Foundation; either version 2.1 of the License, or (at your option) any later
* version.
*
* BigBlueButton is distributed in the hope that it will be useful, but WITHOUT ANY
* WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
* PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public License along
* with BigBlueButton; if not, see <http://www.gnu.org/licenses/>.
* 
*/
package org.bigbluebutton.conference.service.polling;

import org.bigbluebutton.conference.service.polling.PollApplication;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.red5.logging.Red5LoggerFactory;
import org.red5.server.api.so.ISharedObject;

import org.red5.server.api.Red5;

public class PollService {
	
	private static Logger log = Red5LoggerFactory.getLogger( PollingService.class, "bigbluebutton" );
	
	private PollApplication application;

	
	
	public void savePoll(String[] answers, String question , String title , Boolean isMultiple ) {
	
	        log.debug("pollService received answers: "+answers+ " Question: "+question+ " Title: " + title+"" + " isMultiple ? " +isMultiple);
		String roomName = Red5.getConnectionLocal().getScope().getName();
		application.savePoll(answers,question,title,isMultiple, roomName);
	}
	public void setPollApplication(PollApplication a) {
		log.debug("Setting Poll Applications");
		application = a;
	}
	
}
