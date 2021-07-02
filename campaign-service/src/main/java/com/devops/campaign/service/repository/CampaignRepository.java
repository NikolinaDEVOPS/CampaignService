package com.devops.campaign.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devops.campaign.service.model.Campaign;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Integer> {

	Campaign findByCampaignId(Integer id);
}
