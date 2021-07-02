package com.devops.campaign.service.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devops.campaign.service.model.Campaign;
import com.devops.campaign.service.service.CampaignService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/campaign")
@Slf4j
public class CampaignController {
	@Autowired
	private CampaignService campaignService;

	@PostMapping("/")
	public Campaign save(@RequestBody Campaign camp) {
		return campaignService.save(camp);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable Integer id) {
		Campaign campaign = campaignService.findById(id);
		campaignService.deleteById(campaign.getCampaignId());
	}
	
	@GetMapping("/{username}")
	public List<Campaign> findByUsername(@PathVariable String username) {
	    return campaignService.findByUsername(username);
	}
	
	@GetMapping("/id/{id}")
	public Campaign findById(@PathVariable Integer id) {
	    return campaignService.findById(id);
	}
	
	@GetMapping("/{username}/mycampaign")
	public List<Campaign> findUsersCampaign(@PathVariable String username) {
	    try {
			return campaignService.getUsersCampaigns(username);
		} catch (ParseException e) {
			return null;
		}
	}

}