package com.founder.rhip.mdm.controller;

import java.util.ArrayList;
import java.util.List;

public class CheckResult extends ArrayList<List<String>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8316686183040632642L;
	
	public boolean hasError() {
		for (List<String> e : this) {
			if (e != null && e.size() > 0) 
				return true;
		}
		return false;
	}

}
