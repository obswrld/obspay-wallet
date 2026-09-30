from app.config import settings
from fastapi import FastAPI
from app.infrastructure.database import connect_db, disconnect_db
from app.infrastructure.rabbitmq import connect_rabbitmq, disconnect_rabbitmq



app = FastAPI(title="ObsPay Email Service")

@app.on_event("startup")
async def startup():
    await connect_db()
    await connect_rabbitmq()


@app.on_event("shutdown")
async def shutdown():
    await disconnect_db()
    await disconnect_rabbitmq()


@app.get("/health")
async def health_check():
    return {
        "status": "ok",
        "service": "Email-Service",
        "environment": settings.environment,
    }

@app.get("/db-check")
async def db_check():
    from app.infrastructure import database
    async with database.pool.acquire() as conn:
        result = await conn.fetchval("SELECT 1")
    return {"database": "connected", "result": result}

@app.get("/rabbitmq-check")
async def rabbitmq_check():
    from app.infrastructure import rabbitmq
    is_connected = rabbitmq.connection is not None and not rabbitmq.connection.is_closed
    return {"rabbitmq": "connected" if is_connected else "not connected"}
