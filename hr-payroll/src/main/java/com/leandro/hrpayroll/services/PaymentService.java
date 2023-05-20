package com.leandro.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leandro.hrpayroll.entities.Payment;
import com.leandro.hrpayroll.entities.Worker;
import com.leandro.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {

	@Autowired
	private WorkerFeignClient workerFeingClient;

	public Payment getPayment(long workerId, int days) {

		Worker worker = workerFeingClient.findById(workerId).getBody();

		return new Payment(worker.getName(), worker.getDailyIncome(), days);

	}

}
