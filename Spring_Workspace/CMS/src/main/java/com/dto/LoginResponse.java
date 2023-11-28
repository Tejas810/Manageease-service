package com.dto;

public class LoginResponse<Claims> {
    private boolean success;
    private String token;
    private Claims claims;
    public LoginResponse() {
    }
    public LoginResponse(boolean success, String token,Claims claim) {
        this.success = success;
        this.token = token;
        this.claims=claim;
    }
	public boolean isSuccess() {
		return success;
	}
	public Claims getClaims() {
		return claims;
	}
	public void setClaims(Claims claims) {
		this.claims = claims;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	} 
}
