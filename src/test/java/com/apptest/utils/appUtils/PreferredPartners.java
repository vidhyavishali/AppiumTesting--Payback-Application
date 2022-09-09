package com.apptest.utils.appUtils;

public enum PreferredPartners {

	ARAL, DM, REWE, PENNY, FRESSNAPF;


	public static Integer getPartner(String name) {
		for (PreferredPartners partner : values()) {
			if (partner.name().contains(name.toUpperCase()))
				return partner.ordinal();
		}
		return null;
	}
}
