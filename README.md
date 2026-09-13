# Obspay

Obspay is a distributed, event-driven payment and wallet infrastructure platform, built as a microservices system across multiple languages and frameworks.

> Status: 🚧 Under active development — built phase by phase.

## Table of Contents

- [Overview](#overview)
- [Architecture](#architecture)
- [Services](#services)
- [Technology Stack](#technology-stack)
- [Database Architecture](#database-architecture)
- [Event-Driven Architecture](#event-driven-architecture)
- [Payment Flow](#payment-flow)
- [Wallet Flow](#wallet-flow)
- [Authentication Flow](#authentication-flow)
- [Webhook Flow](#webhook-flow)
- [Local Development](#local-development)
- [Environment Variables](#environment-variables)
- [Testing](#testing)
- [Docker](#docker)
- [API Documentation](#api-documentation)

## Overview

*(To be written)*

## Architecture

*(To be written)*

## Services

*(To be written — one subsection per service as each is built)*

## Technology Stack

*(To be written)*

## Database Architecture

*(To be written)*

## Event-Driven Architecture

*(To be written)*

## Payment Flow

*(To be written)*

## Wallet Flow

*(To be written)*

## Authentication Flow

*(To be written)*

## Webhook Flow

*(To be written)*

## Local Development

### Prerequisites

- Docker Desktop installed and running

### Infrastructure Setup

This starts PostgreSQL, Redis, and RabbitMQ as containers.

1. Copy `.env.example` to `.env` and fill in real values (never commit `.env`).
2. Start the infrastructure:

```powershell
   docker compose up -d
```

3. Verify all three containers are healthy:

```powershell
   docker compose ps
```

4. RabbitMQ Management dashboard: http://localhost:15672 (login using `RABBITMQ_USER` / `RABBITMQ_PASSWORD` from your `.env`)

### Databases

PostgreSQL runs as a single container but provisions one isolated database per service on first startup (see `backend/infrastructure/postgres/init-databases.sql`):

`auth_db`, `user_db`, `payment_db`, `wallet_db`, `ledger_db`, `webhook_db`, `notification_db`, `email_db`

No service accesses another service's database directly.

## Environment Variables

*(To be written)*

## Testing

*(To be written)*

## Docker

*(To be written)*

## API Documentation

*(To be written)*