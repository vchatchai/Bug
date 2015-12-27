package com.bug.client.spider.ui.ui;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.bug.client.spider.ui.resources.IMaterialConstants;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.ProvidesKey;
import com.google.gwt.view.client.SelectionModel;

import gwt.material.design.client.custom.MaterialButtonCell;
import gwt.material.design.client.custom.MaterialCheckBoxCell;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialToast;

public class MaterialDataGrid extends Composite {
	private static MaterialDataGridUiBinder uiBinder = GWT.create(MaterialDataGridUiBinder.class);

	interface MaterialDataGridUiBinder extends UiBinder<Widget, MaterialDataGrid> {
	}

	private List<OrderDTO> orders = new ArrayList<OrderDTO>();

	private DataGrid<OrderDTO> dataGrid;
	private ListDataProvider<OrderDTO> orderDTOProvider;
	private ListHandler<OrderDTO> sortDataHandler;
	private final ProvidesKey<OrderDTO> KEY_PROVIDER = new ProvidesKey<OrderDTO>() {

		@Override
		public Object getKey(OrderDTO item) {
			return item.getId();
		}
	};

	private final SelectionModel<OrderDTO> selectionModel = new MultiSelectionModel<OrderDTO>(KEY_PROVIDER);

	private OrderDTO OrderDTO;

	@UiField
	SimplePanel gridPanel;

	@UiField
	SimplePanel pagerPanel;

	public MaterialDataGrid() {
		initWidget(uiBinder.createAndBindUi(this));
		setGrid();
	}

	private void setGrid() {
		dataGrid = createDatagrid();
		gridPanel.setWidget(dataGrid);
//		gridPanel.setHeight("400px");
		dataGrid.setPageSize(9);
		refreshData();
	}

	private void refreshData() {
		orderDTOProvider.setList(new ArrayList<OrderDTO>());
		getAllOrderDTO();
	}

	private DataGrid<OrderDTO> createDatagrid() {

		this.sortDataHandler = new ListHandler<OrderDTO>(new ArrayList<OrderDTO>());
		// CHECKBOX
		Column<OrderDTO, Boolean> checkColumn = new Column<OrderDTO, Boolean>(new MaterialCheckBoxCell()) {
			@Override
			public Boolean getValue(OrderDTO object) {
				boolean value = selectionModel.isSelected(object);
				
				return value;
			}
		};
		
		FieldUpdater<OrderDTO, Boolean> checkColumnFU = new FieldUpdater<OrderDTO, Boolean>() {

            @Override
            public void update(int index, OrderDTO object, Boolean value) {
                selectionModel.setSelected(object, value);
            }
        };
        checkColumn.setFieldUpdater(checkColumnFU);

        // IMAGE
//        Column<OrderDTO, MaterialImage> imageProfile = new Column<OrderDTO, MaterialImage>(new MaterialImageCell()) {
//            @Override
//            public MaterialImage getValue(OrderDTO object) {
//                
//            	MaterialImage img = new MaterialImage();
//            	img.setUrl(object.getUserPicture());
//            	img.setWidth("40px");
//            	img.setHeight("40px");
//            	//SET IMAGE TO CIRCLE
////            	img.setType(ImageType.CIRCLE);
//                return img;
//            }
//            
//        };
        
        // USER
		TextColumn<OrderDTO> colUser = new TextColumn<OrderDTO>() {
			@Override
			public String getValue(OrderDTO object) {

				return object.getUser();
			}
		};
		colUser.setSortable(true);
		sortDataHandler.setComparator(colUser, new Comparator<OrderDTO>() {

			@Override
			public int compare(OrderDTO o1, OrderDTO o2) {

				return o1.getUser().compareTo(o2.getUser());
			}
		});

		// ITEM NAME
		TextColumn<OrderDTO> colName = new TextColumn<OrderDTO>() {
			@Override
			public String getValue(OrderDTO object) {

				return object.getName();
			}
		};
		colName.setSortable(true);
		sortDataHandler.setComparator(colName, new Comparator<OrderDTO>() {

			@Override
			public int compare(OrderDTO o1, OrderDTO o2) {

				return o1.getName().compareTo(o2.getName());
			}
		});

		// PRICE 
		TextColumn<OrderDTO> colPrice = new TextColumn<OrderDTO>() {
			@Override
			public String getValue(OrderDTO object) {

				return object.getPrice();
			}
		};
		colPrice.setSortable(true);
		sortDataHandler.setComparator(colPrice, new Comparator<OrderDTO>() {

			@Override
			public int compare(OrderDTO o1, OrderDTO o2) {

				return o1.getPrice().compareTo(o2.getPrice());
			}
		});

//		// ACTION BUTTON
//		Column<OrderDTO, MaterialButton> showLogBtnColumn = new Column<OrderDTO, MaterialButton>(new MaterialButtonCell()) {
//            @Override
//            public MaterialButton getValue(OrderDTO object) {
//                
//                MaterialButton mb = new MaterialButton("Show log", "blue", "light");
//                mb.setIcon("polymer");
//                mb.setIconPosition("left");
//                mb.getElement().getStyle().setProperty("display", "inline-flex");
//                return mb;
//            }
//            
//        };
        
//        showLogBtnColumn.setFieldUpdater(new FieldUpdater<OrderDTO, MaterialButton>() {
//			
//			@Override
//			public void update(int index, OrderDTO object, MaterialButton value) {
//				MaterialToast.alert(object.getName());
//			}
//		});

		final DataGrid<OrderDTO> dataGrid = new DataGrid<OrderDTO>(100, KEY_PROVIDER);
		dataGrid.setSize("100%", "75vh");

//		dataGrid.addColumn(checkColumn, SafeHtmlUtils.fromSafeConstant("<br/>"));
//		dataGrid.setColumnWidth(checkColumn, "50px");
//		dataGrid.addColumn(imageProfile, "Picture");
		dataGrid.addColumn(colUser, "User");
		dataGrid.addColumn(colName, "Item Name");
		dataGrid.addColumn(colPrice, "Price");
//		dataGrid.addColumn(showLogBtnColumn, "Action");

		dataGrid.setStyleName("striped responsive-table");

		SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
		SimplePager pager = new SimplePager(TextLocation.CENTER, pagerResources, false, 0, true);
		pager.setDisplay(dataGrid);
		pagerPanel.add(pager);

		orderDTOProvider = new ListDataProvider<OrderDTO>();
		orderDTOProvider.addDataDisplay(dataGrid);
		dataGrid.addColumnSortHandler(sortDataHandler);

		return dataGrid;

	}

	private void getAllOrderDTO() {
		orders.add(new OrderDTO(1, "Marjorie","http://b.vimeocdn.com/ps/339/488/3394886_300.jpg", "Nexus", "Php 30000"));
		orders.add(new OrderDTO(1, "Karah","http://lorempixel.com/50/50/people?1", "Asus", "Php 23000"));
		orders.add(new OrderDTO(1, "Xenia","http://lorempixel.com/50/50/people?8", "Oppo", "Php 30000"));
		orders.add(new OrderDTO(1, "Alejandria","http://lorempixel.com/50/50/people?2", "Samsung", "Php 40000"));
		orders.add(new OrderDTO(1, "Alexandria","http://lorempixel.com/50/50/people?2", "Samsung", "Php 40000"));
		orders.add(new OrderDTO(1, "Gigi","http://lorempixel.com/50/50/people?2", "Samsung", "Php 40000"));
		orders.add(new OrderDTO(1, "Marjorie","http://b.vimeocdn.com/ps/339/488/3394886_300.jpg", "Nexus", "Php 30000"));
		orders.add(new OrderDTO(1, "Karah","http://lorempixel.com/50/50/people?1", "Asus", "Php 23000"));
		orders.add(new OrderDTO(1, "Xenia","http://lorempixel.com/50/50/people?8", "Oppo", "Php 30000"));
		orders.add(new OrderDTO(1, "Alejandria","http://lorempixel.com/50/50/people?2", "Samsung", "Php 40000"));
		orders.add(new OrderDTO(1, "Alexandria","http://lorempixel.com/50/50/people?2", "Samsung", "Php 40000"));
		orders.add(new OrderDTO(1, "Gigi","http://lorempixel.com/50/50/people?2", "Samsung", "Php 40000"));
		orderDTOProvider.setList(orders);
		sortDataHandler.setList(orderDTOProvider.getList());
	}

	public OrderDTO getOrderDTO() {
		return OrderDTO;
	}

	public void setOrderDTO(OrderDTO OrderDTO) {
		this.OrderDTO = OrderDTO;
	}
	
//	@UiHandler("rbDefault")
//	void onDefault(ClickEvent e){
//		dataGrid.setStyleName("responsive-table");
//	}
//	
//	@UiHandler("rbBordered")
//	void onBordered(ClickEvent e){
//		dataGrid.setStyleName("bordered responsive-table");
//	}
//	
//	@UiHandler("rbStriped")
//	void onStriped(ClickEvent e){
//		dataGrid.setStyleName("striped responsive-table");
//	}
//
//	@UiHandler("rbHoverable")
//	void onHoverable(ClickEvent e){
//		dataGrid.setStyleName("hoverable responsive-table");
//	}
	
//	@UiHandler("btnSource")
//	void onSource(ClickEvent e){
//		Window.open(IMaterialConstants.LINK_DATAGRID, "" , "_blank");
//		Window.alert("btnSource");
//	}
	
}
