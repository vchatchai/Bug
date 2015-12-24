package com.bug.client.spider.ui.ui;

import gwt.material.design.client.ui.MaterialCollapsible;
import gwt.material.design.client.ui.MaterialCollapsibleItem;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialLink;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class HomePanel extends Composite {

	private static HomePanelUiBinder uiBinder = GWT
			.create(HomePanelUiBinder.class);

	interface HomePanelUiBinder extends UiBinder<Widget, HomePanel> {
	}
	
	
	
	@UiField
	MaterialCollapsible popout;

	public HomePanel() {
		initWidget(uiBinder.createAndBindUi(this));
		MaterialCollapsibleItem item = createMaterialCollapsibleItem();
		popout.addItem(item);
		  item = createMaterialCollapsibleItem();
		popout.addItem(item);
		  item = createMaterialCollapsibleItem();
		popout.addItem(item);
		  item = createMaterialCollapsibleItem();
		popout.addItem(item);
	}
	
	private MaterialCollapsibleItem createMaterialCollapsibleItem(){
		MaterialCollapsibleItem item  = new MaterialCollapsibleItem();
		MaterialLink header = new MaterialLink();
		header.setText("ภาษีมรดก");

		MaterialLabel  label = new MaterialLabel();
		
		item.addHeader(header);
		item.addContent(label);
		return item;
	}
	
	
	private void listActivities(){
		
	}
}
