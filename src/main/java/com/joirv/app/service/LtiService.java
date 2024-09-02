package com.joirv.app.service;

import org.springframework.stereotype.Service;

@Service
public class LtiService {
	private String useRole;

	public void setUseRole(String useRole) {
		this.useRole = useRole;
	}

	public String getUseRole() {
		return this.useRole;
	}
}
