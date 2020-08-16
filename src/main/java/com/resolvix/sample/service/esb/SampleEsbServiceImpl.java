package com.resolvix.sample.service.esb;

import com.resolvix.lib.service.esb.BaseEsbServiceImpl;
import com.resolvix.service.soa.*;

import javax.jws.WebService;

@WebService(
    serviceName = "SampleEsbService",
    portName = "SamplePortType",
    endpointInterface = "com.resolvix.service.soa.SampleService")
public class SampleEsbServiceImpl
    extends BaseEsbServiceImpl
    implements SamplePortType
{

    @Override
    public SampleResponse sampleOperation(SampleRequest request)
        throws SampleFaultOne, SampleFaultTwo
    {
        try {
            return execute(SampleEsbServiceRequestHandlerImpl.class, request);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
