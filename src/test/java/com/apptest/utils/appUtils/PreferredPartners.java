package com.apptest.utils.appUtils;

public enum PreferredPartners {

	ARAL, DM, REWE, PENNY, FRESSNAPF;

	/**Returns the index of the partner based on the name*/
	public static Integer getPartner(String name) {
		for (PreferredPartners partner : values()) {
			if (partner.name().contains(name.toUpperCase()))
				return partner.ordinal() + 1;
		}
		return null;
	}
}
