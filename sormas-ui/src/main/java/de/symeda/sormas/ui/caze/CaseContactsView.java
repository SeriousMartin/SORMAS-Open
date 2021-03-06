package de.symeda.sormas.ui.caze;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import de.symeda.sormas.api.FacadeProvider;
import de.symeda.sormas.api.I18nProperties;
import de.symeda.sormas.api.contact.ContactClassification;
import de.symeda.sormas.api.contact.ContactIndexDto;
import de.symeda.sormas.api.region.DistrictReferenceDto;
import de.symeda.sormas.api.user.UserDto;
import de.symeda.sormas.api.user.UserReferenceDto;
import de.symeda.sormas.api.user.UserRole;
import de.symeda.sormas.ui.ControllerProvider;
import de.symeda.sormas.ui.contact.ContactGrid;
import de.symeda.sormas.ui.login.LoginHelper;

public class CaseContactsView extends AbstractCaseView {

	private static final long serialVersionUID = -1L;
	
	public static final String VIEW_NAME = "cases/contacts";

	private ContactGrid grid;    
    private Button newButton;
	private VerticalLayout gridLayout;

    public CaseContactsView() {
    	super(VIEW_NAME);
        setSizeFull();

        grid = new ContactGrid();
//        grid.setColumns(ContactIndexDto.UUID, ContactIndexDto.PERSON, ContactIndexDto.CONTACT_PROXIMITY, 
//        		ContactIndexDto.LAST_CONTACT_DATE, ContactIndexDto.CONTACT_OFFICER, ContactGrid.ASSOCIATED_CASE);

        gridLayout = new VerticalLayout();
        gridLayout.addComponent(createTopBar());
        gridLayout.addComponent(createFilterBar());
        gridLayout.addComponent(grid);
        gridLayout.setMargin(true);
        gridLayout.setSpacing(false);
        gridLayout.setSizeFull();
        gridLayout.setExpandRatio(grid, 1);
        
        setSubComponent(gridLayout);
    }

	public HorizontalLayout createTopBar() {
    	HorizontalLayout topLayout = new HorizontalLayout();
    	topLayout.setSpacing(true);
    	topLayout.setWidth("100%");
    	
    	Button statusAll = new Button("all", e -> grid.setClassificationFilter(null));
        statusAll.setStyleName(ValoTheme.BUTTON_LINK);
        topLayout.addComponent(statusAll);
        
        for (ContactClassification status : ContactClassification.values()) {
	    	Button statusButton = new Button(status.toString(), e -> {
	    		grid.reload(getCaseRef());
	    		grid.setClassificationFilter(status);
	    	});
	    	statusButton.setStyleName(ValoTheme.BUTTON_LINK);
	        topLayout.addComponent(statusButton);
        }
        
        newButton = new Button("New contact");
        newButton.addStyleName(ValoTheme.BUTTON_PRIMARY);
        newButton.setIcon(FontAwesome.PLUS_CIRCLE);
        newButton.addClickListener(e -> ControllerProvider.getContactController().create(this.getCaseRef()));
        topLayout.addComponent(newButton);
        topLayout.setComponentAlignment(newButton, Alignment.MIDDLE_RIGHT);
        topLayout.setExpandRatio(newButton, 1);
        
        topLayout.setStyleName("top-bar");
        return topLayout;
    }

	public HorizontalLayout createFilterBar() {
    	HorizontalLayout topLayout = new HorizontalLayout();
    	topLayout.setSpacing(true);
    	topLayout.setWidth(100, Unit.PERCENTAGE);
    	
        ComboBox districtFilter = new ComboBox();
        districtFilter.setWidth(240, Unit.PIXELS);
        districtFilter.setInputPrompt(I18nProperties.getPrefixFieldCaption(ContactIndexDto.I18N_PREFIX, ContactIndexDto.CAZE_DISTRICT));
        UserDto user = LoginHelper.getCurrentUser();
        if (user.getRegion() != null) {
        	districtFilter.addItems(FacadeProvider.getDistrictFacade().getAllByRegion(user.getRegion().getUuid()));
        }
        districtFilter.addValueChangeListener(e->grid.setDistrictFilter(((DistrictReferenceDto)e.getProperty().getValue())));
        topLayout.addComponent(districtFilter);

        ComboBox officerFilter = new ComboBox();
        officerFilter.setWidth(240, Unit.PIXELS);
        officerFilter.setInputPrompt(I18nProperties.getPrefixFieldCaption(ContactIndexDto.I18N_PREFIX, ContactIndexDto.CONTACT_OFFICER));
        officerFilter.addItems(FacadeProvider.getUserFacade().getAssignableUsers(user, UserRole.CONTACT_OFFICER));
        officerFilter.addValueChangeListener(e->grid.setContactOfficerFilter(((UserReferenceDto)e.getProperty().getValue())));
        topLayout.addComponent(officerFilter);

        topLayout.setExpandRatio(officerFilter, 1);
        return topLayout;
    }

    @Override
    public void enter(ViewChangeEvent event) {
    	super.enter(event);
    	grid.reload(getCaseRef());
    }

}
