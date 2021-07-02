package com.devops.campaign.service.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.devops.campaign.service.model.Campaign;
import com.devops.campaign.service.model.User;
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

	public void deleteById(Integer campaignId) {
		campaignRepository.deleteById(campaignId);
	}

	public List<Campaign> findByUsername(String username) {
		return campaignRepository.findByUsername(username);
	}
	
	public List<Campaign> getUsersCampaigns(String username) throws ParseException  {
		List<Campaign> campaignsForUser = new ArrayList<>();
		List<Campaign> allCampaigns = campaignRepository.findAll();
		
		
		User[] following =
				restTemplate.getForObject(
				"http://ACCOUNT-SERVICE/user/" + username + "/following"
				, User[].class);
		String gender =
				restTemplate.getForObject(
				"http://ACCOUNT-SERVICE/user/" + username + "/gender"
				, String.class);
		for (Campaign campaign : allCampaigns) {
			Date date = new SimpleDateFormat("dd.MM.yyyy.").parse(campaign.getStartDate());
			if (date.before(new Date())) {
				
				for (User u : following) {
					if (u.getUsername().equals(campaign.getUsername())) {
						campaignsForUser.add(campaign);
						continue;
					}
				}
				if (campaign.getGender().equals(gender)) {
					campaignsForUser.add(campaign);
				}
			}

		}
		return campaignsForUser;

	}}

