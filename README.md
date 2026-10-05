# Meta Lead Ads — React Native PoC

> An offline proof-of-concept for receiving Meta Lead Ads, processing them through a Spring Boot backend, and displaying leads in a React Native dashboard with real-time updates.

---

## 🚀 Overview

This project explores a simple end-to-end lead ingestion pipeline:

```text
                    Meta Lead Ads
                          │
                          ▼
                    Meta Webhook
                          │
                          ▼
                 ┌─────────────────┐
                 │   Spring Boot   │
                 │     Backend     │
                 └────────┬────────┘
                          │
             ┌────────────┼────────────┐
             ▼            ▼            ▼
          Validate     Graph API     MySQL
             │            │            │
             └────────────┴────────────┘
                          │
                     WebSocket
                          │
                          ▼
                 React Native App
                          │
                          ▼
                  Live Lead Dashboard
