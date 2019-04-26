package nc.impl.pqm.pipelinepointdatas.mob;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nc.bs.dao.DAOException;
import nc.impl.am.db.DBAccessUtil;
import nc.itf.pqm.IPipelinepointdatasMaintain;
import nc.itf.pqm.pipelinepointdatas.mob.IPipelinepointDatasMobService;
import nc.vo.bd.meta.BatchOperateVO;
import nc.vo.pm.mobile.base.MobileResultProcessor;
import nc.vo.pm.mobile.base.PMMobVOResultSetProcessor;
import nc.vo.pmbd.mob.util.PMMobilePubUtils;
import nc.vo.pmpub.common.utils.PMProxy;
import nc.vo.pqm.pipelinepointdatas.PipelinepointdatasVO;
import nc.vo.pqm.pipelinepointdatas.mob.PipelinepointdatasListMobVO;
import nc.vo.pqm.pipelinepointdatas.mob.PipelinepointdatasMobVO;
import nc.vo.pub.BusinessException;

public class PipelinepointDatasMobServiceImpl implements
		IPipelinepointDatasMobService {

	@Override
	public Map<String, Object> insertPipelinepointDatas(
			Map<String, Object> param) {
		MobileResultProcessor resultProcessor = new MobileResultProcessor();
		PipelinepointdatasVO[] pipelinepointDatasVOs = new PipelinepointdatasVO[1];
		PipelinepointdatasVO[] pipelinepointDatasreVOs = new PipelinepointdatasVO[1];
		PipelinepointdatasVO pipelinepointDatasVO = new PipelinepointdatasVO();
		BatchOperateVO batchvo = new BatchOperateVO();
		BatchOperateVO batchrevo = new BatchOperateVO();
		String pk_project = (String) param.get("pk_project");
		pipelinepointDatasVO.setAttributeValue(PipelinepointdatasVO.PK_PROJECT, pk_project);
		pipelinepointDatasVOs[0] = pipelinepointDatasVO;
		batchvo.setAddObjs(pipelinepointDatasVOs);
		
		try {
			batchrevo = PMProxy.lookup(IPipelinepointdatasMaintain.class).batchSave(batchvo);
		} catch (BusinessException e) {
			resultProcessor.setErrorMSGAndResultCode(PMMobilePubUtils
					.getErrorMessage(e));
			return resultProcessor.getMobileResultVO();
		}
		pipelinepointDatasreVOs = (PipelinepointdatasVO[]) batchrevo.getAddObjs();
		
		// 构造结果返回MA
		Map<String, String> result = new HashMap<String, String>();
		result.put(PipelinepointdatasVO.PK_PIPELINEPOINTDATAS, pipelinepointDatasreVOs[0].getPrimaryKey());
		resultProcessor.setResult(result);
		return resultProcessor.getMobileResultVO();
	}

	@Override
	public Map<String, Object> queryPipelinepointDatasByProject(
			Map<String, Object> param) {
		MobileResultProcessor resultProcessor = new MobileResultProcessor();
		DBAccessUtil baseDAO = new DBAccessUtil();
		String pk_project = PMMobilePubUtils.changeString(param.get(PipelinepointdatasMobVO.PK_PROJECT));
		
		StringBuffer querySql = new StringBuffer();
		querySql.append(" select pk_pipelinepointdatas,code from pqm_pipelinepointdatas where ");
		querySql.append(" pk_project = '");
		querySql.append(pk_project);
		querySql.append("' and dr = 0 ");
		querySql.append(" order by code ");
		
		List<PipelinepointdatasListMobVO>pipelinepointDatasListMobVOs = null;
		try {
			pipelinepointDatasListMobVOs = baseDAO.executeQuery(
					querySql.toString(),
					new PMMobVOResultSetProcessor<PipelinepointdatasListMobVO>(
							PipelinepointdatasListMobVO.class));
		} catch (DAOException e) {
			resultProcessor.setErrorMSGAndResultCode(PMMobilePubUtils
					.getErrorMessage(e));
			resultProcessor.getMobileResultVO();
		}

		List<Map> queryResult = new ArrayList<Map>();
		if ((pipelinepointDatasListMobVOs != null)
				&& (pipelinepointDatasListMobVOs.size() > 0)) {
			for (PipelinepointdatasListMobVO vo : pipelinepointDatasListMobVOs) {
				queryResult.add(vo.getResultMap());
			}
		}

		resultProcessor.setResult(queryResult);
		return resultProcessor.getMobileResultVO();
	}

	@Override
	public Map<String, Object> queryPipelinepointDatasByPK(
			Map<String, Object> param) {
		MobileResultProcessor resultProcessor = new MobileResultProcessor();
		DBAccessUtil baseDAO = new DBAccessUtil();
		String pk_pipelinepointdatas = PMMobilePubUtils.changeString(param.get(PipelinepointdatasMobVO.PK_PIPELINEPOINTDATAS));
		
		StringBuffer querySql = new StringBuffer();
		querySql.append("select d.longitude,d.latitude,d.elevation,c.name pipelinepointclass_name,g.name pressuregrade_name,d.isline,d.memo ");
		querySql.append("from pqm_pipelinepointdatas d ");
		querySql.append("left join pmbd_pipelinepointclass c ");
		querySql.append("on d.pk_pipelinepointclass = c.pk_pipelinepointclass ");
		querySql.append("left join pmbd_pressuregrade g ");
		querySql.append("on d.pk_pressuregrade = g.pk_pressuregrade ");
		querySql.append("where d.pk_pipelinepointdatas = '");
		querySql.append(pk_pipelinepointdatas);
		querySql.append("' and d.dr = 0 ");
		querySql.append(" order by d.code ");
		
		List<PipelinepointdatasMobVO>pipelinepointDatasMobVOs = null;
		try {
			pipelinepointDatasMobVOs = baseDAO.executeQuery(
					querySql.toString(),
					new PMMobVOResultSetProcessor<PipelinepointdatasMobVO>(
							PipelinepointdatasMobVO.class));
		} catch (DAOException e) {
			resultProcessor.setErrorMSGAndResultCode(PMMobilePubUtils
					.getErrorMessage(e));
			resultProcessor.getMobileResultVO();
		}

		List<Map> queryResult = new ArrayList<Map>();
		if ((pipelinepointDatasMobVOs != null)
				&& (pipelinepointDatasMobVOs.size() > 0)) {
			for (PipelinepointdatasMobVO vo : pipelinepointDatasMobVOs) {
				if(vo.getAttributeValue(PipelinepointdatasMobVO.ISLINE) != null && vo.getAttributeValue(PipelinepointdatasMobVO.ISLINE).equals("Y")){
					vo.setAttributeValue(PipelinepointdatasMobVO.ISLINE, "是");
				}else{
					vo.setAttributeValue(PipelinepointdatasMobVO.ISLINE, "否");
				}
				queryResult.add(vo.getResultMap());
			}
		}

		resultProcessor.setResult(queryResult);
		return resultProcessor.getMobileResultVO();
	}

}
