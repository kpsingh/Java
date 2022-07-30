package com.java.util.concurrent;

import java.util.concurrent.Callable;

public interface IEligibility extends Callable<EligibilityResponse>{

	// this Interface used to do the common things for all the eligibility check
	// task like resource creation, generating the http call uRL for other
	// webSericees etc

}
