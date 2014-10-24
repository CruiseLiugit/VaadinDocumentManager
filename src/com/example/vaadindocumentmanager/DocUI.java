package com.example.vaadindocumentmanager;

import java.io.File;

import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.vaadin.annotations.Theme;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.FilesystemContainer;
import com.vaadin.data.util.TextFileProperty;
import com.vaadin.server.AbstractErrorMessage.ContentMode;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * Vaadin 老板录制视频的案例代码
 * 2014-07-09  10:00
 * 
 * @author lililiu
 *
 */
@SuppressWarnings("serial")
@Theme("vaadindocumentmanager")
public class DocUI extends UI {
	//创建 Container 
	FilesystemContainer docs = new FilesystemContainer(new File("/Users/lililiu/Downloads/tools/JavaBeanValidation框架/apidocs"));
	//创建界面组件
	//案例一，用 下拉框 ComboBox 组件
	//ComboBox docList = new ComboBox("文件", docs);
	//案例二，用 表格 组件
	Table docList = new Table("文件",docs);
	
	//案例一， 用 HTML 格式的 Label 显示内容
	//Label docView = new Label("");
	//案例二，用自定义的 Componts 编辑 内容
	DocEditor docView = new DocEditor();
	
	
	
	
	@Override
	protected void init(VaadinRequest request) {
		//创建页面布局
		HorizontalSplitPanel split = new HorizontalSplitPanel();
		setContent(split);
		
		//往布局中添加组件
		split.addComponent(docList);
		split.addComponent(docView);
		//案例一、代码
		//docView.setContentMode(com.vaadin.shared.ui.label.ContentMode.HTML);
		
		docList.addValueChangeListener(new ValueChangeListener() {
			@Override
			public void valueChange(ValueChangeEvent event) {
				//给 Label 添加 Property 
				docView.setPropertyDataSource(new TextFileProperty((File)event.getProperty().getValue()));
			}
		});
	
		docList.setImmediate(true);
		//table 组件，允许选中单元格
		docList.setSelectable(true);
		docList.setSizeFull();
		
	}
	

	
	
	
	
	
	
	
	
	
	
}