package com.uday.meta_lead_backend.sse;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.uday.meta_lead_backend.dto.LeadResponse;

@Service
public class LeadStreamService {

    private final CopyOnWriteArrayList<SseEmitter> emitters =
            new CopyOnWriteArrayList<>();

    public SseEmitter subscribe() {

        SseEmitter emitter = new SseEmitter(0L);

        emitters.add(emitter);

        emitter.onCompletion(() -> emitters.remove(emitter));
        emitter.onTimeout(() -> emitters.remove(emitter));
        emitter.onError(error -> emitters.remove(emitter));

        try {
            emitter.send(
                    SseEmitter.event()
                            .name("connected")
                            .data("ok")
            );
        } catch (IOException | IllegalStateException e) {
            emitters.remove(emitter);
        }

        return emitter;
    }

    public void broadcast(LeadResponse lead) {

        for (SseEmitter emitter : emitters) {
            try {
                emitter.send(
                        SseEmitter.event()
                                .name("lead")
                                .data(lead)
                );
            } catch (IOException | IllegalStateException e) {
                emitters.remove(emitter);
            }
        }
    }
}