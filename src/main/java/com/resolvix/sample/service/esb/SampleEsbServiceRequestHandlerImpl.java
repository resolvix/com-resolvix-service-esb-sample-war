package com.resolvix.sample.service.esb;

import com.google.common.collect.Maps;
import com.resolvix.lib.service.BaseEsbServiceRequestHandlerImpl;
import com.resolvix.lib.service.ServiceFaultMap;
import com.resolvix.lib.service.api.ServiceException;
import com.resolvix.lib.service.api.ServiceFault;
import com.resolvix.lib.service.api.ServiceFaultMaplet;
import com.resolvix.sample.service.esb.exception.SampleFaultOne;
import com.resolvix.sample.service.esb.exception.SampleFaultTwo;
import com.resolvix.service.soa.SampleRequest;
import com.resolvix.service.soa.SampleResponse;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class SampleEsbServiceRequestHandlerImpl
    extends BaseEsbServiceRequestHandlerImpl<
        SampleRequest,
        SampleResponse,
        ProcessingContext>
{

    private static final List<ServiceFaultMaplet<?, ?, ?>> SERVICE_FAULT_MAPLETS = Arrays.asList(
        ServiceFaultMaplet.of(SampleFaultOne.class, SampleEsbServiceRequestHandlerImpl::toSampleFaultOne),
        ServiceFaultMaplet.of(SampleFaultTwo.class, SampleEsbServiceRequestHandlerImpl::toSampleFaultTwo));

    private static final ServiceFaultMap SERVICE_FAULT_MAP
        = ServiceFaultMap.of(SERVICE_FAULT_MAPLETS);

    public SampleEsbServiceRequestHandlerImpl() {
        //
    }

    private static com.resolvix.service.soa.SampleFaultOne toSampleFaultOne(
        ProcessingContext processingContext,
        SampleFaultOne serviceFaultOne) {
        return null;
    }

    private static com.resolvix.service.soa.SampleFaultTwo toSampleFaultTwo(
        ProcessingContext processingContext,
        SampleFaultTwo serviceFaultTwo) {
        return null;
    }

    @Override
    protected ProcessingContext initialise(SampleRequest sampleRequest)
        throws ServiceException, ServiceFault
    {
        return null;
    }

    @Override
    protected void process(ProcessingContext context)
        throws ServiceException, ServiceFault
    {

    }

    @Override
    protected SampleResponse respond(ProcessingContext context)
        throws ServiceException, ServiceFault
    {
        return null;
    }

    @Override
    protected SampleResponse respond(ProcessingContext context, ServiceException e)
        throws ServiceFault
    {
        return null;
    }

    //@Override
    protected <E extends Exception> E fault(ProcessingContext processingContext, ServiceFault sf)
        throws Exception
    {
        return SERVICE_FAULT_MAP.map(processingContext, sf) ;
    }
}