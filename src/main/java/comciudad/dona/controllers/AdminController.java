package comciudad.dona.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import comciudad.dona.dtos.LoginRequest;
import comciudad.dona.dtos.ResponseEmailDto;
import comciudad.dona.exceptions.GeneralServiceException;
import comciudad.dona.exceptions.NoDataFoundException;
import comciudad.dona.exceptions.ValidateServiceException;
import comciudad.dona.service.AuthService;
import comciudad.dona.utils.WrapperResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/private")
@RequiredArgsConstructor
public class AdminController {
	private final AuthService authService;
	@PutMapping(value = "/reset")
	public ResponseEntity<WrapperResponse<ResponseEmailDto>> reset(
			@RequestBody LoginRequest request) {
		try {
			ResponseEmailDto mensaje = authService.ResetPassword(request);
			return new WrapperResponse<>(true, "success", mensaje).createResponse(HttpStatus.OK);
		} catch (ValidateServiceException e) {
			throw new GeneralServiceException(e.getMessage(), e);
		} catch (NoDataFoundException e) {
			throw new GeneralServiceException(e.getMessage(), e);
		} catch (Exception e) {
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}
	
}
