package com.joirv.app;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/lti")
public class LtiController {


	public ResponseEntity<Map<String,String>> hanletLtiLaunch(HttpServletRequest request ){
		Map<String,String> parameters = new HashMap<>();

		Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			String paramName = parameterNames.nextElement();
			String paramValue = request.getParameter(paramName);
			parameters.put(paramName, paramValue);
		}

		parameters.forEach((key, value) -> {
			System.out.println(key + " : " + value);
		});

		return ResponseEntity.ok(parameters);

	}

}
