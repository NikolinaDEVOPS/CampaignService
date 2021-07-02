package com.devops.campaign.service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.devops.campaign.service.model.Campaign;
import com.devops.campaign.service.repository.CampaignRepository;
@Service
public class CampaignService {
	@Autowired
	private CampaignRepository campaignRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public Campaign save(Campaign camp) {
		return campaignRepository.save(camp);
	}

	public Campaign findById(Integer id) {
		return campaignRepository.findById(id).get();
	}

}

