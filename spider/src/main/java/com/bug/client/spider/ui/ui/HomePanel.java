package com.bug.client.spider.ui.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialContainer;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialLoader;

public class HomePanel extends Composite {

	private static HomePanelUiBinder uiBinder = GWT
			.create(HomePanelUiBinder.class);

	interface HomePanelUiBinder extends UiBinder<Widget, HomePanel> {
	}
	
	@UiField
	MaterialContainer materialContainer;


	@UiField
	MaterialLink homePage;

//	@UiFieldsdf
	// MaterialLinkdf dfregisterPage;
	
	
//	@UiField
//	MaterialCollapsible popout;

	public HomePanel() {
		initWidget(uiBinder.createAndBindUi(this));
//		MaterialCollapsibleItem item = createMaterialCollapsibleItem();
//		popout.addItem(item);
//		  item = createMaterialCollapsibleItem();
//		popout.addItem(item);
//		  item = createMaterialCollapsibleItem();
//		popout.addItem(item);
//		  item = createMaterialCollapsibleItem();
//		popout.addItem(item);
		
		
		
//		registerPage.setText("Chatchai");
//		setHomePage();
		setTrainee();
	}
 
//..loginPage
	
	@UiHandler("loginPage")
	void loginPage(ClickEvent e) {
		setLoginPage();
	}
	

	@UiHandler("homePage")
	void homePage(ClickEvent e) {
		setHomePage();
	}
	
	private void setHomePage() {
		setProgramPage();
		
	}

	@UiHandler("programPage")
	void programPage(ClickEvent e) {
		setProgramPage();
	}

	@UiHandler("traineePage")
	void traineePage(ClickEvent e) {
		setTraineePage();
	}
	

	private void setTraineePage() {
		
		materialContainer.clear();
		materialContainer.add(new MaterialDataGrid());
		
	}
	
	private void setLoginPage() {
		
		materialContainer.clear();
		materialContainer.add(new MaterialLogin());
		
	}

	private void setTrainee(){
		materialContainer.clear();
		materialContainer.add(new MaterialDataGrid());
	}
	
	
	private void setProgramPage(){
		materialContainer.clear();
		materialContainer.add(new Program(materialContainer));
	}
	
	private void setRegisterPage(){
		materialContainer.clear();
		materialContainer.add(new Register(materialContainer));
	}
	
//	private MaterialCollapsibleItem createMaterialCollapsibleItem(){
//		MaterialCollapsibleItem item  = new MaterialCollapsibleItem();
//		MaterialLink header = new MaterialLink();
//		header.setText("ภาษีมรดก");
//
//		MaterialLabel  label = new MaterialLabel();
//		
//		item.addHeader(header);
//		item.addContent(label);
//		return item;
//	}
	
	
	private void listActivities(){
		
	}
}
