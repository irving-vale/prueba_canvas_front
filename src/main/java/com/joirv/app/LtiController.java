package com.joirv.app;

import com.joirv.app.service.LtiService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LtiController {
	@Autowired
	private LtiService ltiService;


//	@PostMapping("/launch")
//	public ResponseEntity<Map<String,String>> hanletLtiLaunch(HttpServletRequest request ){
//		Map<String,String> parameters = new HashMap<>();
//
//		Enumeration<String> parameterNames = request.getParameterNames();
//		while (parameterNames.hasMoreElements()) {
//			String paramName = parameterNames.nextElement();
//			String paramValue = request.getParameter(paramName);
//			parameters.put(paramName, paramValue);
//		}
//
//		parameters.forEach((key, value) -> {
//			System.out.println(key + " : " + value);
//		});
//
//		return ResponseEntity.ok(parameters);
//
//	}

//	@PostMapping("/launch")
//	public ResponseEntity<Map<String, String>> handleLtiLaunch(HttpServletRequest request) {
//		Map<String, String> parameters = new HashMap<>();
//
//		Enumeration<String> parameterNames = request.getParameterNames();
//		while (parameterNames.hasMoreElements()) {
//			String paramName = parameterNames.nextElement();
//			String paramValue = request.getParameter(paramName);
//			parameters.put(paramName, paramValue);
//		}
//
//		// Extraer el rol del usuario de los parámetros
//		String useRole = parameters.get("roles");
//		if (useRole != null) {
//			ltiService.setUseRole(useRole);
//			System.out.println("Rol del usuario: " + useRole);
//		} else {
//			System.out.println("No se recibió un rol.");
//		}
//
//		// Devolver el rol como parte de la respuesta
//		Map<String, String> response = new HashMap<>();
//		response.put("role", useRole); // Enviamos el rol al frontend
//		return ResponseEntity.ok(response);
//	}


	@PostMapping("/launch")
	public void handleLtiLaunch(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// Procesa la solicitud POST
		Map<String, String> parameters = new HashMap<>();
		Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			String paramName = parameterNames.nextElement();
			String paramValue = request.getParameter(paramName);
			parameters.put(paramName, paramValue);
		}

		String useRole = parameters.get("roles");
		if (useRole != null) {
			ltiService.setUseRole(useRole);
			System.out.println("Rol del usuario: " + useRole);
		} else {
			System.out.println("No se recibió un rol.");
		}

		// Redirige al frontend en Netlify después de procesar la solicitud
		response.sendRedirect("https://main--cool-melomakarona-f5fccd.netlify.app/");
	}

	@GetMapping("/role")
	public ResponseEntity<Map<String, String>> getRole() {
		String role = ltiService.getUseRole();
		Map<String, String> response = new HashMap<>();
		response.put("role", role);
		return ResponseEntity.ok(response);
	}

}



