package net.lighting.flow.engine;

import java.util.Map;

import net.lighting.flow.base.FlowItem;
import net.lighting.flow.base.ValueAdapter;
import net.lighting.flow.exception.FlowException;
import net.lighting.flow.factory.XmlFlowFactory;

public class FlowEngine {

    private ValueAdapter valueAdapter;
    
    private Map<String, FlowItem> flowMap;
    
    public FlowEngine() {
        
    }

    public FlowEngine(Map<String, FlowItem> flowMap, ValueAdapter valueAdapter) {
        super();
        this.flowMap = flowMap;
        this.valueAdapter = valueAdapter;
    }
    
    public void setFlowFactory(XmlFlowFactory flowFactory) {
    	flowMap = flowFactory.getFlowMap();
	}

	public void setValueAdapter(ValueAdapter valueAdapter) {
        this.valueAdapter = valueAdapter;
    }

	public void setFlowMap(Map<String, FlowItem> flowMap) {
        this.flowMap = flowMap;
    }

    public void execute(String flowId) throws FlowException {
        flowMap.get(flowId).execute(valueAdapter);
    }
    
    public void execute(String flowId, ValueAdapter values) throws FlowException {
        flowMap.get(flowId).execute(values);
    }
    
}
