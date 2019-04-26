package nc.ui.pqm.pipelinepointdatas.action;

import java.awt.event.ActionEvent;

import nc.ui.pm.excel.ExcelColFiled;
import nc.ui.pm.excel.ExcelSheetInfo;
import nc.ui.pm.excel.SheetParse;
import nc.ui.pmpub.basedoc.action.ExcelExportAction;
import nc.ui.pub.bill.BillItem;
import nc.vo.pm.util.CollectionUtils;

  
/**
 * 管线点数据 —— 导出
 * 
 * @author wugy
 * @Date 2019-04-10
 * 
 */
@SuppressWarnings("serial")
public class PipelinepointdatasExportAction extends ExcelExportAction {
	
	private String bodyVoClassName;
	public String getBodyVoClassName() {
		return this.bodyVoClassName;
	}
	public void setBodyVoClassName(String bodyVoClassName) {
		this.bodyVoClassName = bodyVoClassName;
	}

	@Override
	public void doAction(ActionEvent e) throws Exception {
		super.doAction(e);
	}

	@Override
	public ExcelSheetInfo createSheetInfo() throws Exception {

		String curr_tab_code = getBillListView().getBillCardPanel()
				.getCurrentBodyTableCode();
		String curr_tab_name = getBillListView().getBillCardPanel()
				.getBillData().getBodyTableName(curr_tab_code);

		BillItem[] items = this.getBillListView().getBillCardPanel()
				.getBillData().getBodyItemsForTable(curr_tab_code);
		ExcelSheetInfo sheetInfo = new ExcelSheetInfo();

		// 不需要导出的字段
		String[] notExportFields = new String[] { "pk_org","creator","creationtime","modifier","modifiedtime" };

		if (items != null) {
			sheetInfo.setName(curr_tab_name);
			sheetInfo.setCode(curr_tab_code);
			this.workbook.createSheet(sheetInfo.getName(), 0);
			for (int i = 0; i < items.length; i++) {
				if (items[i].isShow()
						&& !CollectionUtils.convertToList(notExportFields)
								.contains(items[i].getKey())) {
					ExcelColFiled colFiled = new ExcelColFiled();
					String code = items[i].getKey();
					colFiled.setCode(code);
					colFiled.setName(items[i].getName());
					SheetParse sheetParse = this.getParse();
					colFiled.setConvertor(sheetParse.getConvertor(sheetParse
							.getBeanOfVO().getAttributeByName(code)));
					sheetInfo.add(colFiled);
				}
			}
		}
		return sheetInfo;
	}
}
