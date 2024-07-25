package com.tcl;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

@Component(value = "RemoveNewLinesFromExpMsgAndName")
public class RemoveNewLinesFromExpMsgAndName {

	public void removeNewLinesFromExpMsg(Exchange ex) throws Exception {

		String ExpMsg = ex.getProperty("ExpMsg", String.class);
		if (ExpMsg != null) {
			ExpMsg = ExpMsg.replace("\n", "").replace("\r", "");
			ex.setProperty("ExpMsg", ExpMsg);
		}

	}

	public void removeNewLinesFromExpName(Exchange ex) throws Exception {

		String exceptionName = ex.getIn().getHeader("exceptionName", String.class);

		if (exceptionName != null && exceptionName != "") {

			exceptionName = exceptionName.replace("\n", "").replace("\r", "");
			ex.getIn().setHeader(exceptionName, exceptionName);
		}

	}
}
