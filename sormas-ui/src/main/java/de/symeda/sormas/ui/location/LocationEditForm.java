package de.symeda.sormas.ui.location;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import com.vaadin.data.util.converter.StringToDoubleConverter;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;

import de.symeda.sormas.api.FacadeProvider;
import de.symeda.sormas.api.location.LocationDto;
import de.symeda.sormas.api.region.DistrictReferenceDto;
import de.symeda.sormas.api.region.RegionReferenceDto;
import de.symeda.sormas.ui.utils.AbstractEditForm;
import de.symeda.sormas.ui.utils.LayoutUtil;

@SuppressWarnings("serial")
public class LocationEditForm extends AbstractEditForm<LocationDto> {

    private final class StringToAngularLocationConverter extends StringToDoubleConverter {
		protected NumberFormat getFormat(Locale locale) {
			
	        if (locale == null) {
	            locale = Locale.getDefault();
	        }
			
			DecimalFormat numberFormat = (DecimalFormat)NumberFormat.getNumberInstance(locale);
			numberFormat.setGroupingUsed(false);
			numberFormat.setMaximumFractionDigits(5);

			return numberFormat;
		}
	}

	private static final String HTML_LAYOUT = 
    		LayoutUtil.div(
    				LayoutUtil.fluidRow(
    						LayoutUtil.loc(LocationDto.ADDRESS), 
    						LayoutUtil.div(
    								LayoutUtil.fluidRowLocs(LocationDto.REGION, LocationDto.DISTRICT),
    								LayoutUtil.fluidRowLocs(LocationDto.COMMUNITY, LocationDto.CITY))),
    				LayoutUtil.fluidRow(
    						LayoutUtil.loc(LocationDto.DETAILS), 
    						LayoutUtil.fluidRowLocs(LocationDto.LATITUDE, LocationDto.LONGITUDE, LocationDto.LAT_LON_ACCURACY))
    			);

    public LocationEditForm() {
    	super(LocationDto.class, LocationDto.I18N_PREFIX);
    }
    
    public void setFieldsRequirement(boolean required, String... fieldIds) {
    	setRequired(required, fieldIds);
    }

    @Override
	protected void addFields() {
    	addField(LocationDto.ADDRESS, TextArea.class).setRows(2);
    	addField(LocationDto.DETAILS, TextField.class);
    	addField(LocationDto.CITY, TextField.class);
    	
    	addField(LocationDto.LATITUDE, TextField.class).setConverter(new StringToAngularLocationConverter());
    	addField(LocationDto.LONGITUDE, TextField.class).setConverter(new StringToAngularLocationConverter());
    	addField(LocationDto.LAT_LON_ACCURACY, TextField.class);

    	ComboBox region = addField(LocationDto.REGION, ComboBox.class);
    	ComboBox district = addField(LocationDto.DISTRICT, ComboBox.class);
    	ComboBox community = addField(LocationDto.COMMUNITY, ComboBox.class);
    	
    	region.addValueChangeListener(e -> {
    		district.removeAllItems();
    		RegionReferenceDto regionDto = (RegionReferenceDto)e.getProperty().getValue();
    		if (regionDto != null) {
    			district.addItems(FacadeProvider.getDistrictFacade().getAllByRegion(regionDto.getUuid()));
    		}
    	});
    	district.addValueChangeListener(e -> {
    		community.removeAllItems();
    		DistrictReferenceDto districtDto = (DistrictReferenceDto)e.getProperty().getValue();
    		if (districtDto != null) {
    			community.addItems(FacadeProvider.getCommunityFacade().getAllByDistrict(districtDto.getUuid()));
    		}
    	});
		region.addItems(FacadeProvider.getRegionFacade().getAllAsReference());
    }

	@Override
	protected String createHtmlLayout() {
		return HTML_LAYOUT;
	}
}
