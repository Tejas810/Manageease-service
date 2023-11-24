package com.app.services;

import java.util.Date;
import org.springframework.stereotype.Service;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.*;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

@Service
public class JwtTokenProvider {

	private final String secretKey = "NaumanTejas@2023#Kshitij123456789012345678901234567890123456789012345678901234567890";
    private final long validityInMilliseconds = 3600000; // 1 hour

    public String generateToken(String username) {
        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        try {
            JWSSigner signer = new MACSigner(secretKey.getBytes());
            JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                    .subject(username)
                    .issueTime(now)
                    .expirationTime(validity)
                    .build();

            SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);
            signedJWT.sign(signer);

            return signedJWT.serialize();
        } catch (JOSEException e) {
            e.printStackTrace();
            // Handle the exception appropriately for your application
            throw new RuntimeException("Error signing JWT", e);
        }
    }
}
