package de.symeda.sormas.api;

public enum Disease {
	EVD,
	LASSA,
	AVIAN_INFLUENCA,
	CSM,
	CHOLERA,
	MEASLES,
	YELLOW_FEVER,
	DENGUE,
	MONKEYPOX,
	OTHER
	;
	
	public String toString() {
		return I18nProperties.getEnumCaption(this);
	};
	
	public String toShortString() {
		return I18nProperties.getEnumCaption(this, "Short");
	}
	
	public String getName() {
		return this.name();
	}
	
	public boolean hasContactFollowUp() {
		return this == EVD || this == LASSA || this == AVIAN_INFLUENCA || this == MONKEYPOX || this == OTHER;
	}
}
