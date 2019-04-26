package nc.impl.pqm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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
		PipelinepointdatasVO[] pressureVO = checkCodeRepeat(batchVO); 		
		// 添加BP规则
		AroundProcesser<PipelinepointdatasVO> processer = new AroundProcesser<PipelinepointdatasVO>(
				null);
		IRule<PipelinepointdatasVO> rule = null;
		rule = new PipelinepointDatasCheckCodeRule();
		processer.addBeforeRule(rule);
		rule = new PipelinepointDatasSaveRecordRule();
		processer.addBeforeRule(rule);

		processer.before(pressureVO);
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
		Set<String> codeSet = new HashSet<String>();
		Object[] addVOs =  batchVO.getAddObjs();
		Object[] updateVOs = batchVO.getUpdObjs();
		ArrayList<PipelinepointdatasVO> prevolist = new ArrayList<PipelinepointdatasVO>();
		doCheck(addVOs,codeSet,prevolist);
		doCheck(updateVOs,codeSet,prevolist);
		PipelinepointdatasVO[] prevo = new PipelinepointdatasVO[prevolist.size()];
		for(int i = 0; i < prevolist.size();i++){
			prevo[i] = prevolist.get(i);
		}
		return prevo;
	}

	private void doCheck(Object[] addVOs, Set<String> codeSet, ArrayList<PipelinepointdatasVO> prevolist) {
		if(addVOs != null && addVOs.length > 0){
			for(int i = 0;i < addVOs.length;i ++){
				PipelinepointdatasVO vo = (PipelinepointdatasVO) addVOs[i];
				Object codeobj = vo.getAttributeValue("code");
				if(codeobj == null){
					ExceptionUtils.wrappBusinessException("压力等级编码不能为空！");
				}
				String code = (String) codeobj;
				if(codeSet.contains(code)){
					ExceptionUtils.wrappBusinessException("压力等级编码:"+code+"存在重复！");
				}
				codeSet.add(code);
				prevolist.add(vo);
			}			
		}		
	}
}
