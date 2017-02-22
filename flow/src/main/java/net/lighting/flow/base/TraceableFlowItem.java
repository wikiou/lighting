package net.lighting.flow.base;

import net.lighting.flow.exception.FlowException;
import net.lighting.flow.util.FlowUtil;

public abstract class TraceableFlowItem implements FlowItem {

    @Override
    public void execute(ValueAdapter values) throws FlowException {
        String flowTrace = (String) values.get(K.flowTrace);
        if (!FlowUtil.hasText(flowTrace)) {
            flowTrace = "";
        }
        values.set(K.flowTrace, flowTrace + ',' + getClass().getSimpleName());
        execute(values);
    }

}
