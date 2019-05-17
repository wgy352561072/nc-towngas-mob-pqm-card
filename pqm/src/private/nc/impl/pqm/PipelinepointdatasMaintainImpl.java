package nc.impl.pqm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import nc.bs.pqm.pipelinepointdatas.rules.PipelinepointDatasAutoCodeRule;
import nc.bs.pqm.pipelinepointdatas.rules.PipelinepointDatasCheckCodeRule;
import nc.bs.pqm.pipelinepointdatas.rules.PipelinepointDatasSaveRecordRule;
import nc.impl.pub.ace.AcePipelinepointdatasPubServiceImpl;
import nc.impl.pubapp.pattern.rule.IRule;
import nc.impl.pubapp.pattern.rule.processer.AroundProcesser;
import nc.impl.pubapp.pub.smart.BatchSaveAction;
import nc.vo.bd.meta.BatchOperateVO;
import nc.ui.querytemplate.querytree.IQueryScheme;
import nc.vo.pub.BusinessException;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;
import nc.vo.pqm.pipelinepointdatas.PipelinepointdatasVO;
import nc.itf.pqm.IPipelinepointdatasMaintain;


public class PipelinepointdatasMaintainImpl extends AcePipelinepointdatasPubServiceImpl
		implements IPipelinepointdatasMaintain {

	@Override
	public PipelinepointdatasVO[] query(IQueryScheme queryScheme) throws BusinessException {
		return super.pubquerybasedoc(queryScheme);
	}

	@Override
	public BatchOperateVO batchSave(BatchOperateVO batchVO) throws BusinessException {
		checkCodeRepeat(batchVO); 		
		// 添加BP规则
		AroundProcesser<PipelinepointdatasVO> processer4add = new AroundProcesser<PipelinepointdatasVO>(
				null);
		AroundProcesser<PipelinepointdatasVO> processer4update = new AroundProcesser<PipelinepointdatasVO>(
				null);
		IRule<PipelinepointdatasVO> rule = null;
		
		rule = new PipelinepointDatasAutoCodeRule();
		processer4add.addBeforeRule(rule);
		
		rule = new PipelinepointDatasSaveRecordRule();
		processer4add.addBeforeRule(rule);
		processer4update.addBeforeRule(rule);
		
		rule = new PipelinepointDatasCheckCodeRule();
		processer4add.addBeforeRule(rule);
		processer4update.addBeforeRule(rule);
		
		Object[] addVOs =  batchVO.getAddObjs();
		Object[] updateVOs = batchVO.getUpdObjs();
		
		if(addVOs != null && addVOs.length > 0){
			PipelinepointdatasVO[] addplpdatavos = new PipelinepointdatasVO[addVOs.length];
			for(int i = 0; i < addVOs.length; i++){
				addplpdatavos[i] = (PipelinepointdatasVO) addVOs[i];
			}
			processer4add.before(addplpdatavos);
		}
		
		if(updateVOs != null && updateVOs.length > 0){
			PipelinepointdatasVO[] updateplpdatavos = new PipelinepointdatasVO[updateVOs.length];
			for(int i = 0; i < updateVOs.length; i++){
				updateplpdatavos[i] = (PipelinepointdatasVO) updateVOs[i];
			}
			processer4update.before(updateplpdatavos);
		}
			
		BatchSaveAction<PipelinepointdatasVO> saveAction = new BatchSaveAction<PipelinepointdatasVO>();
		BatchOperateVO retData = saveAction.batchSave(batchVO);
		return retData;
	}
	
	/**
	 * 检查编码重复
	 * @param batchVO
	 * @return
	 */
	private PipelinepointdatasVO[] checkCodeRepeat(BatchOperateVO batchVO) {
		Set<Integer> codeSet = new HashSet<Integer>();
		Object[] addVOs =  batchVO.getAddObjs();
		Object[] updateVOs = batchVO.getUpdObjs();
		ArrayList<PipelinepointdatasVO> prevolist = new ArrayList<PipelinepointdatasVO>();
		doCheckInsert(addVOs,codeSet,prevolist);
		doCheckUpdate(updateVOs,codeSet,prevolist);
		PipelinepointdatasVO[] prevo = new PipelinepointdatasVO[prevolist.size()];
		for(int i = 0; i < prevolist.size();i++){
			prevo[i] = prevolist.get(i);
		}
		return prevo;
	}

	private void doCheckInsert(Object[] addVOs, Set<Integer> codeSet, ArrayList<PipelinepointdatasVO> prevolist) {
		if(addVOs != null && addVOs.length > 0){
			for(int i = 0;i < addVOs.length;i ++){
				PipelinepointdatasVO vo = (PipelinepointdatasVO) addVOs[i];
				Object codeobj = vo.getAttributeValue("code");
				if(codeobj != null){
					int code = (int) codeobj;
					if(codeSet.contains(code)){
						ExceptionUtils.wrappBusinessException("管线点数据等级编码:"+code+"存在重复！");
					}
					codeSet.add(code);
				}
				prevolist.add(vo);
			}			
		}		
	}
	
	private void doCheckUpdate(Object[] addVOs, Set<Integer> codeSet, ArrayList<PipelinepointdatasVO> prevolist) {
		if(addVOs != null && addVOs.length > 0){
			for(int i = 0;i < addVOs.length;i ++){
				PipelinepointdatasVO vo = (PipelinepointdatasVO) addVOs[i];
				Object codeobj = vo.getAttributeValue("code");
				if(codeobj == null && vo.getAttributeValue("pk_pipelinepointdatas") != null){
					ExceptionUtils.wrappBusinessException("管线点数据编码不能为空！");
				}
				int code = (int) codeobj;
				if(codeSet.contains(code)){
					ExceptionUtils.wrappBusinessException("管线点数据等级编码:"+code+"存在重复！");
				}
				codeSet.add(code);
				prevolist.add(vo);
			}			
		}		
	}
}
