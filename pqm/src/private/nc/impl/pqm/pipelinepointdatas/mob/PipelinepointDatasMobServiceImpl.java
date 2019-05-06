package nc.impl.pqm.pipelinepointdatas.mob;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nc.bs.dao.DAOException;
import nc.bs.framework.common.InvocationInfoProxy;
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
import nc.vo.pub.lang.UFDateTime;

public class PipelinepointDatasMobServiceImpl implements
		IPipelinepointDatasMobService {

	@Override
	public Map<String, Object> insertPipelinepointDatas(String creator,String pk_group, List<Map> plpList) {
		MobileResultProcessor resultProcessor = new MobileResultProcessor();
		PipelinepointdatasVO[] pipelinepointDatasVOs = new PipelinepointdatasVO[plpList.size()];
		int[] plpindex = new int[plpList.size()];
		BatchOperateVO batchvo = new BatchOperateVO();
		BatchOperateVO batchrevo = new BatchOperateVO();
		for(int i = 0;i<plpList.size();i++){
			Map plpmap = plpList.get(i);			
			PipelinepointdatasVO plpdvo = convertPipelinepointdatasVO(creator,pk_group,plpmap);
			pipelinepointDatasVOs[i] = plpdvo;	
			plpindex[i] = i;
		}
		batchvo.setAddIndexs(plpindex);
		batchvo.setAddObjs(pipelinepointDatasVOs);
		InvocationInfoProxy.getInstance().setGroupId(pk_group);
		
		try {
			batchrevo = PMProxy.lookup(IPipelinepointdatasMaintain.class).batchSave(batchvo);
		} catch (BusinessException e) {
			resultProcessor.setErrorMSGAndResultCode(PMMobilePubUtils
					.getErrorMessage(e));
			return resultProcessor.getMobileResultVO();
		}
	
		// 构造结果返回MA
		Map<String, Integer> result = new HashMap<String, Integer>();
		result.put("success", 0);
		resultProcessor.setResult(result);
		return resultProcessor.getMobileResultVO();
	}

	private PipelinepointdatasVO convertPipelinepointdatasVO(String creator, String pk_group, Map plpmap) {
		PipelinepointdatasVO plpdvo = new PipelinepointdatasVO();
		String islineenum = "N";
		String pk_org = (String) plpmap.get("pk_org");
		String pk_project = (String) plpmap.get("pk_project");
		String longitude = (String) plpmap.get("longitude");
		String latitude = (String) plpmap.get("latitude");
		String elevation = (String) plpmap.get("elevation");
		String pk_pipelinepointclass = (String) plpmap.get("pk_pipelinepointclass");
		String pk_pressuregrade = (String) plpmap.get("pk_pressuregrade");
		String isline = (String) plpmap.get("isline");
		String memo = (String) plpmap.get("memo");
		String creationtime = (String) plpmap.get("creationtime");
		
		if(isline.equals("true")){
			islineenum = "Y";
		}
		
		plpdvo.setAttributeValue("pk_group", pk_group);
		plpdvo.setAttributeValue("creator", creator);
		plpdvo.setAttributeValue("pk_org", pk_org);
		plpdvo.setAttributeValue("pk_project", pk_project);
		plpdvo.setAttributeValue("longitude", longitude);
		plpdvo.setAttributeValue("latitude", latitude);
		plpdvo.setAttributeValue("elevation", elevation);
		plpdvo.setAttributeValue("pk_pipelinepointclass", pk_pipelinepointclass);
		plpdvo.setAttributeValue("pk_pressuregrade", pk_pressuregrade);
		plpdvo.setAttributeValue("isline", islineenum);
		plpdvo.setAttributeValue("memo", memo);
		plpdvo.setAttributeValue("creationtime", new UFDateTime(creationtime));
				
		return plpdvo;
	}

/*	@Override
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
	}*/

	@Override
	public Map<String, Object> queryPipelinepointDatasByProject(
			Map<String, Object> param) {
		MobileResultProcessor resultProcessor = new MobileResultProcessor();
		DBAccessUtil baseDAO = new DBAccessUtil();
		String pk_project = PMMobilePubUtils.changeString(param.get(PipelinepointdatasMobVO.PK_PROJECT));
		
		StringBuffer querySql = new StringBuffer();
		querySql.append("select d.longitude,d.latitude,d.elevation,c.name pipelinepointclass_name,g.name pressuregrade_name,d.isline,d.memo ");
		querySql.append("from pqm_pipelinepointdatas d ");
		querySql.append("left join pmbd_pipelinepointclass c ");
		querySql.append("on d.pk_pipelinepointclass = c.pk_pipelinepointclass ");
		querySql.append("left join pmbd_pressuregrade g ");
		querySql.append("on d.pk_pressuregrade = g.pk_pressuregrade ");
		querySql.append("where d.pk_project = '");
		querySql.append(pk_project);
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
					vo.setAttributeValue(PipelinepointdatasMobVO.ISLINE, "true");
				}else{
					vo.setAttributeValue(PipelinepointdatasMobVO.ISLINE, "false");
				}
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
					vo.setAttributeValue(PipelinepointdatasMobVO.ISLINE, "true");
				}else{
					vo.setAttributeValue(PipelinepointdatasMobVO.ISLINE, "false");
				}
				queryResult.add(vo.getResultMap());
			}
		}

		resultProcessor.setResult(queryResult);
		return resultProcessor.getMobileResultVO();
	}

}
