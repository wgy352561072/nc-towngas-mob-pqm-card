package nc.vo.pqm.pipelinepointdatas;

import nc.vo.pubapp.pattern.model.entity.bill.AbstractBill;
import nc.vo.pubapp.pattern.model.meta.entity.bill.BillMetaFactory;
import nc.vo.pubapp.pattern.model.meta.entity.bill.IBillMeta;

@nc.vo.annotation.AggVoInfo(parentVO = "nc.vo.pqm.pipelinepointdatas.PipelinepointdatasVO")

public class AggPipelinepointdatasVO extends AbstractBill {
	
	  @Override
	  public IBillMeta getMetaData() {
	  	IBillMeta billMeta =BillMetaFactory.getInstance().getBillMeta(AggPipelinepointdatasVOMeta.class);
	  	return billMeta;
	  }
	    
	  @Override
	  public PipelinepointdatasVO getParentVO(){
	  	return (PipelinepointdatasVO)this.getParent();
	  }
	  
}