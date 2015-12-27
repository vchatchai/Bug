//package com.bug.client.spider.ui.ui;
//
//import com.google.gwt.core.client.GWT;
//import com.google.gwt.event.dom.client.ClickEvent;
//import com.google.gwt.uibinder.client.UiBinder;
//import com.google.gwt.uibinder.client.UiField;
//import com.google.gwt.uibinder.client.UiHandler;
//import com.google.gwt.user.client.ui.Composite;
//import com.google.gwt.user.client.ui.Widget;
//
//import gwt.material.design.client.ui.MaterialButton;
//import gwt.material.design.client.ui.MaterialCollapsible;
//import gwt.material.design.client.ui.MaterialCollapsibleItem;
//import gwt.material.design.client.ui.MaterialContainer;
//import gwt.material.design.client.ui.MaterialLabel;
//import gwt.material.design.client.ui.MaterialLink;
//
//public class Trainee extends Composite {
//
//	private static ProgramUiBinder uiBinder = GWT.create(ProgramUiBinder.class);
//
//	interface ProgramUiBinder extends UiBinder<Widget, Trainee> {
//	}
//
//	@UiField
//	MaterialButton register;
//	@UiField
//	MaterialCollapsible popout;
//
//	private MaterialContainer materialContainer;
//
//	public Trainee(MaterialContainer materialContainer) {
//		this.materialContainer = materialContainer;
//		initWidget(uiBinder.createAndBindUi(this));
//
//		// MaterialCollapsibleItem item = createMaterialCollapsibleItem();
//		// popout.addItem(item);
//		// item = createMaterialCollapsibleItem();
//		// popout.addItem(item);
//		// item = createMaterialCollapsibleItem();
//		// popout.addItem(item);
//		// item = createMaterialCollapsibleItem();
//		// popout.addItem(item);
//
//		// registerPage.setText("Chatchai");
//	
//
//	}
//
//	@UiHandler("register")
//	void register(ClickEvent e) {
//		setRegister();
//	}
//
//	@UiHandler("register1")
//	void register1(ClickEvent e) {
//		setRegister();
//	}
//
//	@UiHandler("register2")
//	void register2(ClickEvent e) {
//		setRegister();
//	}
//
//	@UiHandler("register3")
//	void register3(ClickEvent e) {
//		setRegister();
//	}
//
//	@UiHandler("register4")
//	void register4(ClickEvent e) {
//		setRegister();
//	}
//
//	@UiHandler("register5")
//	void register5(ClickEvent e) {
//		setRegister();
//	}
//
//	private void setRegister() {
//
//		materialContainer.clear();
//		materialContainer.add(new Register(materialContainer));
//	}
//
//	private MaterialCollapsibleItem createMaterialCollapsibleItem() {
//		MaterialCollapsibleItem item = new MaterialCollapsibleItem();
//		MaterialLink header = new MaterialLink();
//		header.setText("ภาษีมรดก");
//
//		MaterialLabel label = new MaterialLabel();
//
//		item.addHeader(header);
//		item.addContent(label);
//		return item;
//	}
//
//	private void listActivities() {
//
//	}
//}
