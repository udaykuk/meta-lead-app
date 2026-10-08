package com.uday.meta_lead_backend.webhook;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uday.meta_lead_backend.dto.MetaWebhookRequest;
    
@RestController
@RequestMapping("/api/webhook/meta")
public class MetaWebhookController {
@Value("${meta.verify-token}")
private String verifyToken;
@GetMapping
public ResponseEntity<String> verifyWebhook(
    
        @RequestParam(name = "hub.mode") String mode,
        @RequestParam(name = "hub.verify_token") String verifyTokenFromMeta,
        @RequestParam(name = "hub.challenge") String challenge) {

 if ("subscribe".equals(mode) && this.verifyToken.equals(verifyTokenFromMeta)) {
    return ResponseEntity.ok(challenge);
}

return ResponseEntity.status(HttpStatus.FORBIDDEN).build();}
@PostMapping
public ResponseEntity<Void> receiveWebhook(@RequestBody MetaWebhookRequest payload) {

    System.out.println("Meta webhook received:");
    System.out.println(payload);

    return ResponseEntity.ok().build(); 
}
}